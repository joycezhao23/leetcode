class Solution {
    public int maxSizeSlices(int[] slices) {
        int n = slices.length, m = n / 3;
        int[] arr1 = Arrays.copyOfRange(slices, 0, n - 1);
        int[] arr2 = Arrays.copyOfRange(slices, 1, n);
        return Math.max(helper(arr1, m), helper(arr2, m));
    }
    
    private int helper(int[] arr, int n) {
        int m = arr.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= Math.min(i,n); j++) {
                if (i == 1) dp[i][j] = arr[i - 1];
                else dp[i][j] = Math.max(dp[i - 2][j - 1] + arr[i - 1], dp[i - 1][j]);
            }
        }
        return dp[m][n];
    }
}