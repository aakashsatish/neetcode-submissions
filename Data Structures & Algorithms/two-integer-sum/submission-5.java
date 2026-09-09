class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numbers = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            numbers.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(numbers.containsKey(complement) && numbers.get(complement) != i){
                return new int[] {i , numbers.get(complement)};
            }
        }
        return new int[] {};
    }
}
