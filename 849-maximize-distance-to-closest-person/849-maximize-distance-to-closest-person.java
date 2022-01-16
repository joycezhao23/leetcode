class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int prev = -1, max = 0;
        for (int i = 0; i < n; i++) {
            if (seats[i] == 0) {
                continue;
            }
            int dist = prev == -1 ? i : (i - prev) / 2;
            max = Math.max(max, dist);
            prev = i;
        } 
        if (prev != n - 1) max = Math.max(max, n - 1 - prev);
        return max;
    }
}