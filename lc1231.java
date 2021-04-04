class Solution {
    public int maximizeSweetness(int[] sweetness, int K) {
        int l = 0, r = 0;
        for (int i : sweetness) {
            l = Math.min(l, i);
            r += i;
        }
        r = (r + K) / (K + 1);
        
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (getCuts(sweetness, mid) >= K + 1) {
                l = mid;
            } else {
                r = mid;
            }
        }
        
        if (getCuts(sweetness, r) == K + 1) return r;
        return l;
    }
    
    private int getCuts(int[] sweetness, int t) {
        int res = 0, cur = 0;
        for (int i : sweetness) {
            cur += i;
            if (cur >= t) {
                cur = 0;
                res++;
            }
        }
        return res; 
    }
}