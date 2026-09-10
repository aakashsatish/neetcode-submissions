class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        s = {}
        for i in range(len(nums)):
            dif = target - nums[i]
            if dif in s:
                return [s.get(dif), i]
            else:
                s[nums[i]] = i
        
