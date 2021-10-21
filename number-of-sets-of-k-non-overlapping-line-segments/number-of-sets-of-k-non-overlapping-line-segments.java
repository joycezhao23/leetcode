class Solution {
    public int numberOfSets(int n, int k) {
        Integer[][][] dp = new Integer[n + 1][k + 1][2];
        this.n = n;
        return helper(0, k, 1, dp);
    }
    int MOD = 1000000007;
    int n;
    
    private int helper(int idx, int k, int isStart, Integer[][][] dp) {
        if (dp[idx][k][isStart] != null) return dp[idx][k][isStart];
        if (k == 0) return 1;
        if (idx == n) return 0;
        int res = helper(idx + 1, k, isStart, dp);
        if (isStart == 1) {
            res += helper(idx + 1, k, 0, dp);
        } else {
            res += helper(idx, k - 1, 1, dp);
        }
        return dp[idx][k][isStart] = res % MOD;
    }
}