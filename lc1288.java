class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        
        int count = 0, start = intervals[0][0], end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] itv = intervals[i];
            if (itv[0] >= start && itv[1] <= end) {
                count++;
            } else {
                start = itv[0];
                end = itv[1];
            }
        }
        
        return intervals.length - count;
    }
}