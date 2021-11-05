class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size(), MOD = 1000000007;
        long[][][] dp = new long[n + 1][n + 1][2];
        dp[n - 1][n - 1] = new long[]{0, 1};
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == n-1 && j == n-1 || board.get(i).charAt(j) == 'X')
                    continue;
                long max = Math.max(dp[i + 1][j][0], Math.max(dp[i][j + 1][0], dp[i + 1][j + 1][0]));
                long count = 0;
                if (dp[i + 1][j][0] == max) count += dp[i + 1][j][1];
                if (dp[i + 1][j + 1][0] == max) count += dp[i + 1][j + 1][1];
                if (dp[i][j + 1][0] == max) count += dp[i][j + 1][1];
                if (count == 0) continue;
                dp[i][j][1] = count % MOD;
                dp[i][j][0] = max + (board.get(i).charAt(j) == 'E' ? 0 : board.get(i).charAt(j) - '0');
            }
        }
        int[] res = new int[]{(int)dp[0][0][0], (int)dp[0][0][1]};
        return res;
    }
}