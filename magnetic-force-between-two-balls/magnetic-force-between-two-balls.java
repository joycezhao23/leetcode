class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length, lo = 1, hi = position[n - 1] - position[0], mid;
        while (lo + 1 < hi) {
            mid = lo + (hi - lo) / 2;
            if (balls(position, mid) >= m) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return (balls(position, hi) >= m) ? hi : lo;
    }
    
    private int balls(int[] position, int minL) {
        int res = 1, i = 0, n = position.length;
        while (i < n) {
            int next = position[i] + minL, j = i + 1;
            for (;j < n; j++) {
                if (position[j] >= next) {
                    res++;
                    i = j;
                    break;
                }
            }
            if (j == n) break;
        }
        return res;
    }
}