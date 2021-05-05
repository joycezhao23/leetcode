class Solution {
    public int findKthNumber(int m, int n, int k) {
        int lo = 1, hi = m * n;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (getCount(m, n, mid) >= k) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        
        return getCount(m, n, lo) >= k ? lo : hi;
    }
    
    private int getCount(int m, int n, int target) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(target / i, n);
        }
        return count;
    }
}