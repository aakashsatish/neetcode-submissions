class Solution {
    private HashMap<Character, HashSet<Character>> map;
    private HashMap<Character, Boolean> visited;
    private ArrayList<Character> result;
    public String foreignDictionary(String[] words) {
      map = new HashMap<>();
      for(String word : words){
        for(char c : word.toCharArray()){
            map.putIfAbsent(c, new HashSet<>());
        }
      }
      for(int i = 0; i < words.length - 1; i++){
        String w1 = words[i], w2 = words[i + 1];
        int minLen = Math.min(w1.length(), w2.length());
        if(w1.length() > w2.length() && w1.substring(0, minLen).equals(w2.substring(0,minLen))){
            return "";
        }
        for(int j = 0; j < minLen; j++){
            if(w1.charAt(j) != w2.charAt(j)){
                map.get(w1.charAt(j)).add(w2.charAt(j));
                break;
            }
        }
      }
        result = new ArrayList<>();
        visited = new HashMap<>();
        for(char c : map.keySet()){
            if(dfs(c)){
                return "";
            }
        }
        Collections.reverse(result);
        StringBuilder sb = new StringBuilder();
        for(char c : result){
            sb.append(c);
        }
        return sb.toString();
      
    }
    private boolean dfs(char ch){
        if(visited.containsKey(ch)){
            return visited.get(ch);
        }
        visited.put(ch, true);
        for(char next : map.get(ch)){
            if(dfs(next)){
                return true;
            }
        }
        visited.put(ch, false);
        result.add(ch);
        return false;
      }
}
