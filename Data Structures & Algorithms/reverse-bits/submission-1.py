class Solution:
    def reverseBits(self, n: int) -> int:
        m = format(n, '032b')
        m = m[::-1]
        place = 0
        res = 0
        for i in range(len(m) - 1, -1 , -1):
            res += ((2**place) * int(m[i]))
            place += 1
        return res
