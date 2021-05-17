class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length, res = n + 1, l = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum >= target) {
                res = Math.min(res, i - l + 1);
                sum -= nums[l++];
            }            
        }
        return res == n + 1 ? 0 : res;
    }
}