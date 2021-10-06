class Solution {
    int m = 0, n = 0;
    char[][] g;
    public int numIslands(char[][] grid) {
        int count = 0;
        m = grid.length;
        n = grid[0].length; 
        g = grid;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == '1') {
                    dfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};
    
    private void dfs(int x, int y) {
        g[x][y] = '0';
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i], yy = y + dy[i];
            if (isValid(xx, yy)) {
                dfs(xx, yy);
            }
        }
    }
    
    private boolean isValid(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n && g[x][y] == '1';
    }
}