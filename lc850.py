class Solution(object):
    def rectangleArea(self, rectangles):
        """
        :type rectangles: List[List[int]]
        :rtype: int
        """
        MOD = 10 ** 9 + 7
        
        events = []
        for x1, y1, x2, y2 in rectangles:
            events.append([x1, y1, y2, 0]);
            events.append([x2, y1, y2, 1]);
        events.sort(key=lambda x : (x[0], x[3]));
        
        def get_area(m):
            if m == 0: return 0 
            area = prev = 0
            for l, r in open_intervals:
                area += max(0, (r - max(prev, l)) * m)
                prev = max(prev, r)
            return area % MOD
        
        area = prev = 0
        open_intervals = []
        
        for curr, y1, y2, close in events:
            area = (area + get_area(curr - prev)) % MOD
            if close:
                open_intervals.remove((y1, y2))
            else:
                open_intervals.append((y1, y2));
                open_intervals.sort()
            prev = curr
                
        return area
        
        