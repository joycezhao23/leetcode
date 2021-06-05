class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
    
    private int mergeSort(int[] nums, int lo, int hi) {
        if (lo >= hi) return 0;
        int res = 0, mid = lo + (hi - lo) / 2;
        res += mergeSort(nums, lo, mid);
        res += mergeSort(nums, mid + 1, hi);
        res += merge(nums, lo, mid, hi);
        return res;
    }
    
    private int merge(int[] nums, int lo, int mid, int hi) {
        int[] tmp = new int[hi - lo + 1];
        int i = lo, j = mid + 1, count = 0;
        while (i <= mid && j <= hi) {
            if (nums[i] > (long)2 * nums[j]) {
                count += mid - i + 1;
                j++;
            } else {
                i++;
            }
        }
        i = lo;
        j = mid + 1;
        int k = 0;
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
        return count;
    }
}