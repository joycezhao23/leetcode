class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[2][n + 2];
        for (int i = 0; i < 2; i++) {
            dp[i][0] = 100000;
            dp[i][n + 1] = 100000;
        }
        for (int i = 0; i < m; i++) {
            int row = i % 2, last = 1 - row;
            for (int j = 1; j < n + 1; j++) {
                dp[row][j] = Math.min(dp[last][j - 1], Math.min(dp[last][j], dp[last][j + 1])) + matrix[i][j - 1];
            }
        }
        int res = Integer.MAX_VALUE, row = (m - 1) % 2;
        for (int i = 1; i < n + 1; i++)
            res = Math.min(res, dp[row][i]);
        return res;
    }
}