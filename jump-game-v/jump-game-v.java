class Solution {
    int res = 0;
    
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        for (int i = 0; i < n; i++) {
            helper(arr, i, dp, d, n);
        }
        return res + 1;
    }
    
    private int helper(int[] arr, int i, int[] dp, int d, int n) {
        if (dp[i] >= 0) return dp[i];
        dp[i] = 0;
        for (int j = i - 1; j >= Math.max(0, i - d); j--) {
            if (arr[i] <= arr[j]) break;
            dp[i] = Math.max(dp[i], helper(arr, j, dp, d ,n) + 1);
        }
        
        for (int j = i + 1; j <= Math.min(n - 1, i + d); j++) {
            if (arr[i] <= arr[j]) break;
            dp[i] = Math.max(dp[i], helper(arr, j, dp, d ,n) + 1);
        }
        res = Math.max(res, dp[i]);
        return dp[i];
    }
}