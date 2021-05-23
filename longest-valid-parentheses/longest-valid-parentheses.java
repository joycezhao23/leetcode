class Solution {
    public int longestValidParentheses(String s) {
        int res = 0, n = s.length();
        if (n < 2) return res;
        int[] dp = new int[n + 1];
        
        for (int i = 2; i <= n; i++) {
            if (s.charAt(i - 1) == '(') continue;
            if (s.charAt(i - 2) == '(') dp[i] = dp[i - 2] + 2;
            if (i - dp[i - 1] - 2 >= 0 && s.charAt(i - dp[i - 1] - 2) == '(') {
                dp[i] = Math.max(dp[i], dp[i - 1] + 2 + dp[i - dp[i - 1] - 2]);
            }
            res = Math.max(res, dp[i]);
        }
        
        return res;
    }
}