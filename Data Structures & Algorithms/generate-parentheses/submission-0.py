class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        stack = []
        res = [] 
        def backtrack(start, end):
            if start == end == n:
                res.append("".join(stack))
                return 
            if start < n:
                stack.append("(")
                backtrack(start + 1, end)
                stack.pop()
            if end < start:
                stack.append(")")
                backtrack(start, end + 1)
                stack.pop()
        backtrack(0, 0)
        return res