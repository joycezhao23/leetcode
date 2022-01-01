class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] ns = new int[n + 2];
        System.arraycopy(nums, 0, ns, 1, n);
        ns[0] = ns[n + 1] = 1;
        int[][] dp = new int[n + 2][n + 2];
        for (int l = 2; l < n + 2; l++) {
            for (int i = 0; i + l < n + 2; i++) {
                for (int j = i + 1; j < i + l; j++) {
                    dp[i][i + l] = Math.max(dp[i][i + l], ns[i] * ns[j] * ns[i + l] + dp[i][j] + dp[j][i + l]);
                }
            }
        }
        
        return dp[0][n + 1];
    }
}