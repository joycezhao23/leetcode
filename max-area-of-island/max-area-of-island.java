class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0)
                    continue;
                res = Math.max(res, dfs(grid, i, j));
            }
        }
        return res;
    }
    
    int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};
    
    private int dfs(int[][] grid, int x, int y) {
        int count = 1;
        grid[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i], yy = y + dy[i];
            if (xx >= 0 && xx < grid.length && yy >= 0 && yy < grid[0].length && grid[xx][yy] == 1) {
                count += dfs(grid, xx, yy);
            }
        }
        return count;
    }
}