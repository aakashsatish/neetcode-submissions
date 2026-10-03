class Solution:
    def lastStoneWeightII(self, stones: list[int]) -> int:
        totalSum = sum(stones)
        target = totalSum // 2
        def dfs(i, total):
            if total >= target or i == len(stones):
                return abs(total - (totalSum - total))
            if (i, total) in dp:
                return dp[(i, total)]
            dp[(i, total)] = min(dfs(i + 1, total), dfs(i + 1, total + stones[i]))
            return dp[(i, total)]
        dp = {}
        return dfs(0,0)