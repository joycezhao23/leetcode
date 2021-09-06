class Solution {
    int[][] grid;
    int rows, cols;
    int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};
    
    public int shortestBridge(int[][] grid) {
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
        boolean flag = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0)
                    continue;
                dfs(i, j);
                flag = true;
                break;
            }
            if (flag) break;
        }
        
        for (int color = 2; ; color++) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] != color)
                        continue;
                    for (int k = 0; k < 4; k++) {
                        if (expand(i + dx[k], j + dy[k], color + 1)) 
                            return color - 2;
                    }
                }
            }
        }
    }
    
    private boolean expand(int x, int y, int color) {
        if (!isValid(x, y))
            return false;
        if (grid[x][y] == 0)
            grid[x][y] = color;
        return grid[x][y] == 1;
    }
    
    private void dfs(int x, int y) {
        if (!isValid(x, y) || grid[x][y] == 0 || grid[x][y] == 2)
            return;
        grid[x][y] = 2;
        for (int i = 0; i < 4; i++) 
            dfs(x + dx[i], y + dy[i]);
    }
    
    private boolean isValid(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}