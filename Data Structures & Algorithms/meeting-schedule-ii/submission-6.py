"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def minMeetingRooms(self, intervals: List[Interval]) -> int:
        start = []
        end = []
        for interval in intervals: 
            start.append(interval.start)
            end.append(interval.end)
        start.sort()
        end.sort()
        s = e = n = 0
        res = 0
        while s < len(intervals):
            if start[s] < end[e]:
                s+=1
                n += 1
            else:
                e += 1
                n -= 1
            res = max(n, res)
        return res


