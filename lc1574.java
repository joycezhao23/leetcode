class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int l = 0, r = arr.length - 1;
        
        while (l < arr.length - 1 && arr[l] <= arr[l + 1]) l++;
        if (l == arr.length - 1) return 0;
        
        while(r > l && arr[r - 1] <= arr[r]) r--;
        int res = Math.min(arr.length - l - 1, r);
        
        int i = 0, j = r;
        while (i <= l && j < arr.length) {
            if (arr[i] <= arr[j]) {
                res = Math.min(res, j - i - 1);
                i++;
            } else {
                j++;
            }
        }
        
        return res;
    }
}