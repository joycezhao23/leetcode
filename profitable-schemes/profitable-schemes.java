class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int l = group.length, MOD = 1000000007;
        int[][] dp = new int[n + 1][minProfit + 1];
        dp[0][0] = 1;
        for (int i = 0; i < l; i++) {
            int g = group[i], p = profit[i];
            for (int j = n - g; j >= 0; j--) {
                for (int k = minProfit; k >= 0; k--) {
                    dp[j + g][Math.min(minProfit, k + p)] = (dp[j + g][Math.min(minProfit, k + p)] + dp[j][k]) % MOD;
                }
            }
        }
        int res = 0;
        for (int i = 0; i <= n; i++) 
            res = (res + dp[i][minProfit]) % MOD;
        return res;
    }
}