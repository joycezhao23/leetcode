class Solution {
    public int findDerangement(int n) {
        if (n <= 1) return 0;
        long[] dp = new long[n + 1];
        dp[0] = dp[1] = 0;
        dp[2] = 1;
        int MOD = 1000000007;
        for (int i = 3; i <= n; i++) {
            dp[i] = (((dp[i - 1] + dp[i - 2]) % MOD) * (i - 1)) % MOD;
        }
        return (int)dp[n];
    }
}