class Solution {
    public int numWays(String[] words, String target) {
        int n = words[0].length(), m = target.length(), l = words.length;
        long[][] dp = new long[n + 1][m + 1];
        int MOD = 1000000007;
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;
        int[][] count = new int[128][n];
        for (String s : words) {
            for (int i = 0; i < n; i++) {
                count[s.charAt(i)][i]++;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1] * count[target.charAt(j - 1)][i - 1]) % MOD;
            }
        }
        return (int)dp[n][m];
    }
}