class Solution {
    public String minWindow(String s, String t) {
        if(t == ""){
            return "";
        }
        HashMap<Character, Integer> countT = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for(int i = 0; i < t.length(); i++){
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
        }
        int have = 0;
        int need = countT.size();
        int[] res = new int[] {-1, -1};
        float resLen = Float.POSITIVE_INFINITY;
        int left = 0;
        for(int r = 0; r < s.length(); r++){
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c,0)+ 1);
            if(countT.containsKey(c) && window.get(c)== countT.get(c)){
                have += 1;
            }
            while(have == need){
                if((r - left + 1) < resLen){
                    res[0] = left;
                    res[1] = r;
                    resLen = r - left + 1;
                }
                char u = s.charAt(left);
                window.put(u, window.get(u) - 1);
                if(countT.containsKey(u) && window.get(u) < countT.get(u)){
                    have -= 1;
                }
                left++;
            }
        }
        if(resLen != Float.POSITIVE_INFINITY){
            return s.substring(res[0], res[1] + 1);
        }
        return "";
        
    }
}
