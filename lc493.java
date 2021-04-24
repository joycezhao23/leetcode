class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
    
    private int mergeSort(int[] nums, int lo, int hi) {
        if (lo >= hi) return 0;
        int mid = lo + (hi - lo) / 2;
        int count = mergeSort(nums, lo, mid) + mergeSort(nums, mid + 1, hi);
        
        int loPtr = lo, hiPtr = mid + 1;
        while (loPtr <= mid && hiPtr <= hi) {
            if (nums[loPtr] > 2 * Long.valueOf(nums[hiPtr])) {
                count += mid - loPtr + 1;
                hiPtr++;
            } else {
                loPtr++;
            }
        }
        
        while (hiPtr++ <= hi) {
            count += mid - loPtr + 1;
        }
        
        merge(nums, lo, mid, mid + 1, hi);
        return count;
    }
    
    private void merge(int[] nums, int lo, int loEnd, int hi, int hiEnd) {
        int[] tmp = new int[hiEnd - lo + 1];
        int idx = 0, loPtr = lo, hiPtr = hi;
        
        while (loPtr <= loEnd && hiPtr <= hiEnd) {
            if (nums[loPtr] < nums[hiPtr]) {
                tmp[idx++] = nums[loPtr++];
            } else {
                tmp[idx++] = nums[hiPtr++];
            }
        }
        
        while (loPtr <= loEnd) tmp[idx++] = nums[loPtr++];
        while (hiPtr <= hiEnd) tmp[idx++] = nums[hiPtr++];
        
        System.arraycopy(tmp, 0, nums, lo, hiEnd - lo + 1);
    }
}