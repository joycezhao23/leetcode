class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][i] = 0;
        }
        for (int l = 1; l <= n; l++) {
            for (int i = 1; i + l <= n; i++) {
                if (l == 1) dp[i][i + l] = i;
                else {
                    for (int k = i + 1; k < i + l; k++) {
                        dp[i][i + l] = Math.min(dp[i][i + l], k + Math.max(dp[i][k - 1], dp[k + 1][i + l]));
                    }
                }
            }
        }
        return dp[1][n];        
    }
}