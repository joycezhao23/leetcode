class Solution {
    public int longestOnes(int[] nums, int k) {
        int res = 0, czero = 0, lo = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                czero++;
                res = Math.max(res, i - lo);
                while (czero > k) {
                    if (nums[lo++] == 0) czero--;
                }
            }
        }
        return Math.max(res, nums.length - lo);
    }
}