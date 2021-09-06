class Solution {
    int[][] grid;
    int m, n;
    public int closedIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        
        for (int i = 0; i < m; i++) {
            dfs(i, 0);
            dfs(i, n - 1);
        }
        
        for (int i = 0; i < n; i++) {
            dfs(0, i);
            dfs(m - 1, i);
        }
        
        int count = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 0) {
                    count++;
                    dfs(i, j);
                }
            }
        }
        return count;
    }
    
    int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};
    
    private void dfs(int x, int y) {
        if (!isValid(x, y))
            return;
        grid[x][y] = 1;
        for (int i = 0; i < 4; i++)
            dfs(x + dx[i], y + dy[i]);
    }
    
    private boolean isValid(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 0;
    }
}