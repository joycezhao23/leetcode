class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        m = grid1.length;
        n = grid1[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1)
                    count += dfs(grid1, grid2, i, j);
            }
        }
        return count;
    }
    
    int m, n;
    
    private int dfs(int[][] g1, int[][] g2, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || g2[x][y] == 0) return 1;
        g2[x][y] = 0;
        int res = 1;
        res &= dfs(g1, g2, x + 1, y);
        res &= dfs(g1, g2, x, y + 1);
        res &= dfs(g1, g2, x - 1, y);
        res &= dfs(g1, g2, x, y - 1);
        return res & g1[x][y];
    }
}