class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) 
            dp[i][i] = piles[i];
        for (int l = 1; l < n; l++) {
            for (int i = 0; i + l < n; i++) {
                dp[i][i + l] = Math.max(piles[i] - dp[i+1][i+l], piles[i + l] - dp[i][i + l - 1]);
            }
        }
        return dp[0][n - 1] > 0;
    }
}