class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) suffixSum[i] = suffixSum[i + 1] + piles[i];
        return helper(0, 1, piles, suffixSum, new int[n][n]);
    }
    
    private int helper(int idx, int M, int[] piles, int[] ssum, int[][] memo) {
        if (idx + 2 * M >= piles.length) return ssum[idx];
        if (memo[idx][M] != 0) return memo[idx][M];
        int res = 0;
        for (int x = 1; x <= 2 * M; x++) {
            res = Math.max(res, ssum[idx] - helper(idx + x, Math.max(x, M), piles, ssum, memo));
        }
        memo[idx][M] = res;
        return res;
    }
}