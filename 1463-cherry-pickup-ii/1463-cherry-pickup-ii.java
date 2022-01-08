class Solution {
    public int cherryPickup(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Integer[][][] dp = new Integer[rows][cols][cols];
        return helper(grid, rows, cols, 0, 0, cols - 1, dp);
    }
    
    private int helper(int[][] grid, int rows, int cols, int r, int c1, int c2, Integer[][][] dp) {
        if (r == rows)
            return 0;
        if (dp[r][c1][c2] != null) 
            return dp[r][c1][c2];
        int max = 0;
        for (int i = -1; i <= 1; i++) {
            int nc1 = c1 + i;
            for (int j = -1; j <= 1; j++) {
                int nc2 = c2 + j;
                if (nc1 >= 0 && nc1 < cols && nc2 >= 0 && nc2 < cols) {
                    max = Math.max(max, helper(grid, rows, cols, r + 1, nc1, nc2, dp));
                }
            }
        }
        return dp[r][c1][c2] = c1 == c2 ? max + grid[r][c1] : max + grid[r][c1] + grid[r][c2];
    }
}