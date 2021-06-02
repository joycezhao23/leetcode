class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        if (n1 + n2 != n3) return false;
        if (n3 == 0) return true;
        boolean[][] dp = new boolean[2][n2 + 1];
        dp[0][0] = true;
        for (int i = 0; i < n2; i++) dp[0][i + 1] = dp[0][i] && s2.charAt(i) == s3.charAt(i);
        for (int i = 1; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                int row = i % 2;
                if (j == 0) {
                    dp[row][j] = dp[1 - row][j] && s1.charAt(i - 1) == s3.charAt(i - 1);
                } else {
                    dp[row][j] = dp[1 - row][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1) || dp[row][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);    
                }
            }
        }
        return dp[n1 % 2][n2];
    }
}