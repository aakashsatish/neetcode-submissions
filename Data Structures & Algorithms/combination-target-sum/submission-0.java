class Solution {
    ArrayList<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0, target, nums, new ArrayList<>(), 0);
        return res;
    }
    public void dfs(int i, int target, int[] nums, List<Integer> curr, int total){
        if(total == target){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int j = i; j < nums.length; j++){
            if(total + nums[j] >target){
                return;
            }
            curr.add(nums[j]);
            dfs(j, target, nums, curr, total + nums[j]);
            curr.remove(curr.size() - 1);
        }
    }
}
