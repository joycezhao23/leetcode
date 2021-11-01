class Solution {
    public int maxHeight(int[][] cubs) {
        int n = cubs.length;
        for (int[] cub : cubs)
            Arrays.sort(cub);
        Arrays.sort(cubs, (a, b) -> a[0] == b[0] ? (a[1] == b[1] ? b[2] - a[2] : b[1] - a[1]) : b[0] - a[0]);
        int res = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = cubs[i][2];
            for (int j = i - 1; j >= 0; j--) {
                if (cubs[i][0] <= cubs[j][0] && cubs[i][1] <= cubs[j][1] && cubs[i][2] <= cubs[j][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + cubs[i][2]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}