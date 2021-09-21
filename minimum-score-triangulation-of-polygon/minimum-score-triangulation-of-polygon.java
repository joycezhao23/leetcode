class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for (int d = 2; d < n; d++) {
            for(int i = 0; i + d < n; i++) {
                dp[i][i + d] = Integer.MAX_VALUE;
                for (int j = i + 1; j < i + d; j++) {
                    dp[i][i + d] = Math.min(dp[i][i + d], dp[i][j] + dp[j][i + d] + values[i] * values[j] * values[i + d]);
                }
            }
        }
        return dp[0][n - 1];
    }
}