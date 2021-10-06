class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        if (k == 0) return res;
        int l = 0, r = 0, length = nums.length, product = 1;
        while (r < length) {
            product *= nums[r++];
            while (product >= k && l < r) {
                product /= nums[l++];
            }
            res += r - l;
        }
        return res;
    }
}