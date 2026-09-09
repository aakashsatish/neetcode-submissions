class Solution {
    public int maxSubArray(int[] nums) {
        int curMax = nums[0];
        int curSum = 0;

        for(int n : nums){
            if(curSum < 0){
                curSum = 0;
            }
            curSum += n;
            curMax = Math.max(curSum, curMax);
        }
        return curMax;
    }
}
