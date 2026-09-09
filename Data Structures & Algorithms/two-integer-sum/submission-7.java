class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> values = new HashMap<>(); 
        for(int i=0; i < nums.length; i++){
            int comp = target  - nums[i];
            if(values.containsKey(comp)){
                return new int[] {values.get(comp), i};
            }
            values.put(nums[i], i);
        }
        return new int[] {};
    }
}
