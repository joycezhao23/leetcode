class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length, lo = 0, hi = n - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (citations[mid] < n - mid) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        if (citations[lo] >= n - lo) return n - lo;
        if (citations[hi] >= n - hi) return n - hi;
        
        return 0;
    }
}