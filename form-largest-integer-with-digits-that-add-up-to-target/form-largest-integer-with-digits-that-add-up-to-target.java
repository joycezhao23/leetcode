class Solution {
    public String largestNumber(int[] cost, int target) {
        String[] dp = new String[target + 1];
        dp[0] = "";
        for (int i = 1; i < 10; i++) {
            for (int j = cost[i - 1]; j <= target; j++) {
                if (dp[j - cost[i - 1]] == null) continue;
                dp[j] = comp(dp[j], Integer.toString(i) + dp[j - cost[i - 1]]);
            }
        }
        return dp[target] == null ? "0" : dp[target];
    }
    
    private String comp(String x, String y) {
        if (x == null) return y;
        if (x.length() > y.length()) {
            return x;
        } else if (x.length() < y.length()) {
            return y;
        }
        return x.compareTo(y) < 0 ? y : x;
    }
}