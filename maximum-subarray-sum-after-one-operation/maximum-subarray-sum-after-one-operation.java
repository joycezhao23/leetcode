class Solution {
    public int maxSumAfterOperation(int[] nums) {
        int[][] dp = new int[nums.length + 1][2];
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            dp[i + 1][0] = Math.max(dp[i][0] + nums[i], nums[i]);
            dp[i + 1][1] = Math.max(Math.max(dp[i][0] + nums[i] * nums[i], dp[i][1] + nums[i]), nums[i] * nums[i]);
            res = Math.max(res, dp[i + 1][1]);
        }
        return res;
    }
}