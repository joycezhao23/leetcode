class Solution {
    public int arrangeCoins(int n) {
        long l = 0, r = n, val = 2 * (long)n;
        while (l + 1 < r) {
            long mid = l + (r - l) / 2;
            if (mid * mid + mid > val) {
                r = mid;
            } else if (mid * mid + mid == val) {
                return (int)mid;
            } else {
                l = mid;
            }
        }
        return (r * r + r <= 2 * n) ? (int)r : (int)l;
    }
}