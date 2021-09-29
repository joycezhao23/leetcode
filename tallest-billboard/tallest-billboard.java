class Solution {
    public int tallestBillboard(int[] rods) {
        int[] dp = new int[5001];
        for (int i = 1; i <= 5000; i++) dp[i] = -10000;
        for (int rod : rods) {
            int[] cur = dp.clone();
            for (int d = 0; d + rod <= 5000; d++) {
                dp[d + rod] = Math.max(dp[d + rod], cur[d]);
                int nd = Math.abs(d - rod);
                dp[nd] = Math.max(dp[nd], cur[d] + Math.min(d, rod));
            }
        }        
        
        return dp[0];
    }
}