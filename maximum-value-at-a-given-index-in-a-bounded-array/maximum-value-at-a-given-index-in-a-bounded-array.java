class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int lo = 0, hi = maxSum, mid;
        while (lo + 1 < hi) {
            mid = lo + (hi - lo) / 2;
            if (sum(n, index, mid) == maxSum) return mid;
            if (sum(n, index, mid) < maxSum) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return sum(n, index, hi) <= maxSum ? hi : lo;
    }
    
    private long sum(int n, int index, int val) {
        int left = Math.min(index, val - 1), right = Math.min(n - index, val);
        long leftSum = (long)left * (val - 1) - (long)(left) * (left - 1) / 2 + (index - left);
        long rightSum = (long)(right) * val - (long)(right) * (right - 1) / 2 + (n - index - right);
        return leftSum + rightSum;
    }
}