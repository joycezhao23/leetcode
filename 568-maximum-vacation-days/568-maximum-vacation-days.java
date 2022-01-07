class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int cities = flights.length, weeks = days[0].length;
        int[][] dp = new int[weeks + 1][cities];
        for (int i = weeks - 1; i >= 0; i--) {
            for (int j = 0; j < cities; j++) {
                dp[i][j] = dp[i + 1][j] + days[j][i];
                for (int k = 0; k < cities; k++) {
                    if (flights[j][k] == 1) {
                        dp[i][j] = Math.max(dp[i][j], dp[i + 1][k] + days[j][i]);
                    }
                }
            }
        }
        int max = dp[0][0];
        for (int i = 1; i < cities; i++) {
            if (flights[0][i] == 1)
                max = Math.max(max, dp[0][i]);
        }
        return max;
    }
}