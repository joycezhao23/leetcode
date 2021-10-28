class Solution {
    int MOD = 1000000007;
    Integer[] dp;
    public int numberOfArrays(String s, int k) {
        dp = new Integer[s.length()];
        return helper(s, k, 0);
    }
    
    private int helper(String s, int k, int start) {
        if (start == s.length()) return 1;
        if (s.charAt(start) == '0') return 0;
        if (dp[start] != null) return dp[start];
        long res = 0, num = 0;
        for (int i = start; i < s.length(); i++) {
            num = num * 10 + s.charAt(i) - '0';
            if (num > k) break;
            res = (res + helper(s, k, i + 1)) % MOD;
        }
        return dp[start] = (int)res;
    }
}