class Solution {
    public int[] sortedSquares(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
    
    private void mergeSort(int[] nums, int lo, int hi) {
        if (lo > hi) return;
        if (lo == hi) {
            nums[lo] = nums[lo] * nums[lo];
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid + 1, hi);
        
        int[] tmp = new int[hi - lo + 1];
        int i = lo, j = mid + 1, k = 0;
        while (i <= mid && j <= hi) {
            if (nums[i] < nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
            }
        }
        while (i <= mid) tmp[k++] = nums[i++];
        while (j <= hi) tmp[k++] = nums[j++];
        System.arraycopy(tmp, 0, nums, lo, hi - lo + 1);
    }
}