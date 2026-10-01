class Solution:
    def checkValidString(self, s: str) -> bool:
        opens = []
        stars = []
        
        for i, c in enumerate(s):
            if c == '(':
                opens.append(i)
            elif c == '*':
                stars.append(i)
            else:
                if opens:
                    opens.pop()
                elif stars:
                    stars.pop()
                else:
                    return False
        while opens:
            if stars and stars[-1] > opens[-1]:
                stars.pop()
                opens.pop()
            else:
                return False
        return True 