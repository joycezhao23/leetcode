class Solution {
    public int maxProductPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long[][][] dp = new long[m][n][2];
        dp[0][0] = new long[]{grid[0][0], grid[0][0]};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if (j == 0) {
                    dp[i][j][0] = dp[i][j][1] = grid[i][j] * dp[i - 1][j][0]; 
                } else if (i == 0) {
                    dp[i][j][0] = dp[i][j][1] = grid[i][j] * dp[i][j - 1][0]; 
                } else {
                    long a = Math.max(dp[i][j - 1][0], dp[i - 1][j][0]);
                    long b = Math.min(dp[i][j - 1][1], dp[i - 1][j][1]);
                    dp[i][j][0] = Math.max(a * grid[i][j], b * grid[i][j]);
                    dp[i][j][1] = Math.min(a * grid[i][j], b * grid[i][j]);
                }
            }
        }
        if (dp[m - 1][n - 1][0] < 0) return -1;
        return (int)(dp[m - 1][n - 1][0] % 1000000007);
    }
}