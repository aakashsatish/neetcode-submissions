class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxLength = 0;
        int highestFreq = 0;
        
        while(right < s.length()){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            highestFreq = Math.max(highestFreq, map.get(s.charAt(right)));
            int toReplace = (right - left + 1) - highestFreq;

            if(toReplace > k){
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left += 1;
            }
            maxLength = right - left + 1;
            right += 1;
        }
        return maxLength;
    }
}
