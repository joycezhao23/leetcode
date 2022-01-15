class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            int n1 = s.charAt(i) - '0';
            if (n1 >= 1 && n1 <= 9) dp[i + 1] += dp[i];
            if (i > 0) {
                int n2 = Integer.valueOf(s.substring(i - 1, i + 1));
                if (n2 >= 10 && n2 <= 26) dp[i + 1] += dp[i - 1];
            }
        }
        return dp[n];
    }
}