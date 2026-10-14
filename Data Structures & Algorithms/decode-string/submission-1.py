class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        for c in s:
            if c != ']':
                stack.append(c)
            else:
                chunk = ""
                while stack[-1].isalpha():
                    chunk = stack.pop() + chunk
                stack.pop()
                num = ""
                while stack and stack[-1].isdigit():
                    num = stack.pop() + num
                num = int(num)
                stack.append(chunk * num)
        return "".join(stack)