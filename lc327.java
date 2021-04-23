class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sums = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        
        return mergeSort(sums, 0, n, lower, upper);
    }
    
    private int mergeSort(long[] sums, int lo, int hi, int lower, int upper) {
        if (lo >= hi) return 0;
        int mid = lo + (hi - lo + 1) / 2;
        int count = mergeSort(sums, lo, mid - 1, lower, upper) + mergeSort(sums, mid, hi, lower, upper);
        int startIdx = mid, endIdx = mid;
        
        for (int i = lo; i < mid; i++) {
            while (startIdx <= hi && sums[startIdx] - sums[i] < lower) startIdx++;
            while (endIdx <= hi && sums[endIdx] - sums[i] <= upper) endIdx++;
            
            count += endIdx - startIdx;
        }
        
        merge(sums, lo, mid, hi, lower, upper);
        return count;
    }
    
    private void merge(long[] sums, int lo, int mid, int hi, int lower, int upper) {
        long[] tmp = new long[hi - lo + 1];
        int loPtr = lo, hiPtr = mid, idx = 0;
        while (loPtr < mid && hiPtr <= hi) {
            if (sums[loPtr] <= sums[hiPtr]) {
                tmp[idx++] = sums[loPtr++];
            } else {
                tmp[idx++] = sums[hiPtr++];
            }
        }
        
        while (loPtr < mid) tmp[idx++] = sums[loPtr++];
        while (hiPtr <= hi) tmp[idx++] = sums[hiPtr++];
        System.arraycopy(tmp, 0, sums, lo, hi - lo + 1);
    }
}