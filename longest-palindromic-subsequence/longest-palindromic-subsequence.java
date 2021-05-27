class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = 1;
        for (int i = 0; i < n - 1; i++) dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1) ? 2 : 1;
        for (int l = 2; l < n; l++) {
            for (int i = 0; i + l < n; i++) {
                dp[i][i + l] = Math.max(dp[i][i + l - 1], dp[i + 1][i + l]);
                if (s.charAt(i) ==  s.charAt(i + l)) {
                    dp[i][i + l] = Math.max(dp[i][i + l], 2 + dp[i + 1][i + l - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}