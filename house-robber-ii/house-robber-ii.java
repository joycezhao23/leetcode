class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n < 2) return nums[0];
        int[][] dp = new int[n][2];
        dp[1][1] = nums[0];
        for (int i = 1; i < n - 1; i++) {
            dp[i + 1][0] = Math.max(dp[i][0], dp[i][1]);
            dp[i + 1][1] = Math.max(dp[i - 1][0], dp[i - 1][1]) + nums[i];
        }
        int res = Math.max(dp[n - 1][0], dp[n - 1][1]);
        dp[1][1] = nums[1];
        for (int i = 2; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = Math.max(dp[i - 2][0], dp[i - 2][1]) + nums[i];
        }
        return Math.max(res, Math.max(dp[n - 1][0], dp[n - 1][1]));
    }
}