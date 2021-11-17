class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][][] presum = new int[m + 1][n + 2][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                presum[i + 1][j + 1][0] = presum[i][j][0] + grid[i][j];
                presum[i + 1][j + 1][1] = presum[i][j + 2][1] + grid[i][j];
            }
        }
        
        TreeSet<Integer> res = new TreeSet<Integer>((a, b) -> b - a);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res.add(grid[i][j]);
                for (int k = 1; k < m; k++) {
                    if (i + 2 * k > m - 1 || j - k < 0 || j + k >= n)
                        break;
                    int sol = presum[i + k + 1][j - k + 1][1] 
                        - presum[i][j + 2][1] 
                        + presum[i + 2 * k + 1][j + 1][0] 
                        - presum[i + k][j - k][0] 
                        + presum[i + 2 * k + 1][j + 1][1] 
                        - presum[i + k][j + k + 2][1] 
                        + presum[i + k + 1][j + k + 1][0] 
                        - presum[i][j][0] - grid[i][j] - grid[i+k][j-k] - grid[i+k][j+k] - grid[i+2*k][j];
                    res.add(sol);
                }
            }
        }
        int[] r = new int[Math.min(3, res.size())];
        for (int i = 0; i < 3 && !res.isEmpty(); i++) {
            r[i] = res.pollFirst();
        }
        return r;
    }
}