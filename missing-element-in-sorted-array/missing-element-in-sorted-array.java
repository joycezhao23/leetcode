class Solution {
    public int missingElement(int[] nums, int k) {
        int n = nums.length, l = 0, r = n - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            int missing = nums[mid] - nums[0] - mid;
            if (k > missing) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return k > nums[r] - nums[0] - r ? k + nums[0] + r : k + nums[0] + l;
    }
}