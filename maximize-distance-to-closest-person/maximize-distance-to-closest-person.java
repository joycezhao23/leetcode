class Solution {
    public int maxDistToClosest(int[] seats) {
        int prev = -1, max = 0, cur = 0, n = seats.length;
        while (cur < n) {
            if (seats[cur] == 1) {
                if (prev == -1) {
                    max = cur;
                } else {
                    max = Math.max(max, (cur - prev) / 2);
                }
                prev = cur;
            }
            cur++;
        }
        if (prev != cur) max = Math.max(max, n - prev - 1);
        return max;
    }
}