class Solution {
    public int twoEggDrop(int n) {
        return helper(n, 2, new int[n + 1][3]);
    }
    
    private int helper(int floors, int eggs, int[][] dp) {
        if (eggs == 1 || floors <= 1) 
            return floors;
        if (dp[floors][eggs] > 0)
            return dp[floors][eggs];
        dp[floors][eggs] = Integer.MAX_VALUE;
        for (int i = 1; i <= floors; i++) {
            dp[floors][eggs] = Math.min(dp[floors][eggs], 1 + Math.max(helper(i - 1, eggs - 1, dp), helper(floors - i, eggs, dp)));
        }
        return dp[floors][eggs];
    }
}