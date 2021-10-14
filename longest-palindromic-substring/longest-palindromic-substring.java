class Solution {
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        char[] cs = s.toCharArray();
        int n = cs.length;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++)
            dp[i][i] = true;
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = cs[i] == cs[i + 1];
            if (dp[i][i + 1]) {
                start = i;
                end = i + 1;
            }
        }
            
        for (int l = 2; l < n; l++) {
            for (int i = 0; i + l < n; i++) {
                dp[i][i + l] = (cs[i] == cs[i + l]) && dp[i + 1][i + l - 1];
                if (dp[i][i + l]) {
                    start = i;
                    end = i + l;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}