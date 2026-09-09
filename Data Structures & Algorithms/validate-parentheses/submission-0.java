class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');

        for(int i = 0;  i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){ //if a closing character
                if(!stack.isEmpty() && stack.peek() == map.get(c)){ //top of stack is matching closing
                    stack.pop();//remove it 
                }
                else{
                    return false;//wrong closing 
                }
            }
            else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
