class Solution:
    def reverse(self, x: int) -> int:
        n = str(x)
        neg = False
        if n[0] == '-':
            neg = True
        n = n[::-1]
        res = ""
        for i in range(len(n)):
            if n[i] == '-':
                continue
            res += n[i]
        res = map(str, res)
        res = "".join(res)
        if int(res) > (2**31-1) or int(res) < (-2 ** 31):
            return 0
        return (int(res) * -1) if neg else int(res)