class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        while len(stones) > 1:
            stones.sort()
            res = stones.pop() - stones.pop()
            if res > 0:
                stones.append(res)
        return stones[0] if stones else 0