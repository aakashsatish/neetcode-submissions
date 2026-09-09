class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int longest = 0;
        for(int i : nums){
            set.add(i);
        }

        for(int i = 0; i < nums.length; i++){

            if(!set.contains(nums[i] - 1)){
                int length = 0;
                while(set.contains(nums[i] + length)){
                    length += 1;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}
