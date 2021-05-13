class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length, right = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] < max) {
                right = i;
            }
            max = Math.max(nums[i], max);
        }
        int left = n - 1, min = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > min) {
                left = i;
            }
            min = Math.min(min, nums[i]);
        }
        return right - left > 0 ? right - left + 1 : 0;
    }
}