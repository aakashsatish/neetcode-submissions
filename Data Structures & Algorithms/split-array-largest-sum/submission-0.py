class Solution:
    def splitArray(self, nums: List[int], k: int) -> int:
        dp = {}
        
        def dfs(i, k):
            if k == 1:
                return sum(nums[i:])
            if (i, k) in dp:
                return dp[(i, k)]
            res = float('inf')
            curSum = 0
            for j in range(i, len(nums) - k + 1):
                curSum += nums[j]
                maxSum = max(curSum, dfs(j + 1, k - 1))
                res = min(maxSum, res)

                if curSum > res:
                    break
            dp[(i, k)] = res
            return res
        return dfs(0, k)



