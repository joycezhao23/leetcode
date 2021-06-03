class Solution {
    public int maximizeSweetness(int[] arr, int K) {
        int lo = 1, hi = Integer.MAX_VALUE;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (chunk(arr, mid) > K) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        if (chunk(arr, hi) > K) return hi;
        return lo;
    }
    
    private int chunk(int[] arr, int t) {
        int res = 0, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] < t) {
                sum += arr[i];                
            } else if (sum + arr[i] >= t) {
                res++;
                sum = 0;
            }
        }
        return res;
    }
}