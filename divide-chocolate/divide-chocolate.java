class Solution {
    public int maximizeSweetness(int[] sweetness, int k) {
        int l = 0, r = Integer.MAX_VALUE;
        arr = sweetness;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (valid(mid, k)) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return valid(r, k) ? r : l;
    }
    int[] arr;
    
    private boolean valid(int s, int k) {
        int count = 0, cur = 0;
        for (int i = 0; i < arr.length; i++) {
            cur += arr[i];
            if (cur >= s) {
                count++;
                cur = 0;
            }
        }
        return count >= k + 1;
    }
}