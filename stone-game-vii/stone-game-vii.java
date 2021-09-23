class Solution {
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[] presum = new int[n + 1];
        for (int i = 0; i < n; i++) 
            presum[i + 1] = presum[i] + stones[i];
        int[][] dp = new int[n][n];
        for (int l = 1; l < n; l++) {
            for (int i = 0; i + l < n; i++) {
                dp[i][i + l] = Math.max(presum[i+l+1] - presum[i+1] - dp[i + 1][i + l], presum[i+l] - presum[i] - dp[i][i+l-1]);
            }
        }
        return dp[0][n - 1];
    }
}