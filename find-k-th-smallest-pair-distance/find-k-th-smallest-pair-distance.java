class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, lo = 0, hi = nums[n - 1] - nums[0];
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (getCount(nums, mid) >= k) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return getCount(nums, lo) >= k ? lo : hi;
    }
    
    private int getCount(int[] nums, int target) {
        int count = 0, n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int pos = getFirstGT(nums, nums[i] + target);
            count += pos - i - 1;
        }
        return count;
    }
    
    private int getFirstGT(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        if (nums[hi] <= target) return hi + 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] <= target) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        
        return nums[lo] > target ? lo : hi;
    }
}