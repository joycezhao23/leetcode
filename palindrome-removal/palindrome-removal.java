class Solution {
    public int minimumMoves(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = 1;
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = arr[i] == arr[i + 1] ? 1 : 2;
        }
        for (int l = 2; l < n; l++) {
            for (int i = 0; i + l < n; i++) {
                dp[i][i + l] = 1 + dp[i + 1][i + l];
                if (arr[i] == arr[i + 1])
                    dp[i][i + l] = Math.min(dp[i][i + l], 1 + dp[i + 2][i + l]);
                if (arr[i] == arr[i + l])
                    dp[i][i + l] = Math.min(dp[i][i + l], dp[i + 1][i + l - 1]);
                for (int k = i + 2; k < i + l; k++) {
                    if (arr[i] == arr[k]) {
                        dp[i][i + l] = Math.min(dp[i][i + l], dp[i + 1][k - 1] + dp[k + 1][i + l]);    
                    }                    
                }
            }
        }
        return dp[0][n - 1];
    }
}