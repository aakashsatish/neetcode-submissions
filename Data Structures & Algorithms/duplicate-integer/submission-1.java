class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> checks = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(checks.contains(nums[i])){
                return true;
            }
            else{
                checks.add(nums[i]);
            }
        }
        return false;
        
    }
}