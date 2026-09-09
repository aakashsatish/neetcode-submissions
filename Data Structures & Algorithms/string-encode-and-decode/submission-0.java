class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            int count = s.length();
            sb.append(count);
            sb.append('#');
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        ArrayList<String> result = new ArrayList<>();
        char[] chars = str.toCharArray();
        int count;
        for(int i = 0; i < chars.length; i++){
            StringBuilder sb = new StringBuilder();
            while(Character.isDigit(chars[i])){
                sb.append(chars[i]);
                i++;
            }
            int len = Integer.parseInt(sb.toString());
            if(chars[i] == '#'){
                i+= 1;
            }
            StringBuilder temp = new StringBuilder();
            for(int j = i; j < (i + len) && j < chars.length; j++){
                temp.append(chars[j]);
            }
            result.add(temp.toString());
            i += len - 1;
        }
        return result;



    }
}
