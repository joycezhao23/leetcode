class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> a[1] < b[1] ? -1 : 1);
        int count = 1, n = points.length, pos = points[0][1];
        for (int i = 0; i < n; i++) {
            if (points[i][0] <= pos)
                continue;
            count++;
            pos = points[i][1];
        }
        return count;
    }
}