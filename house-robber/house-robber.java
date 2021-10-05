class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][2];
        dp[1][0] = 0;
        dp[1][1] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i + 1][0] = Math.max(dp[i][0], dp[i][1]);
            dp[i + 1][1] = Math.max(dp[i - 1][0], dp[i - 1][1]) + nums[i];
        }
        return Math.max(dp[n][0], dp[n][1]);
    }
}