class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (m * k > n) return -1;
        
        int l = 1, r = (int)Math.pow(10, 9);
        
        while (l < r) {
            int mid = l + (r - l) / 2, days = 0, bouq = 0;
            for (int j = 0; j < n; j++) {
                if (bloomDay[j] > mid) {
                    days = 0;
                } else if (++days == k) {
                    bouq++;
                    days = 0;
                }
            }
            if (bouq >= m) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        
        return l;
    }
}