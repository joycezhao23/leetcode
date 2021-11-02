class Solution {
    public int uniquePathsIII(int[][] grid) {
        g = grid;
        m = grid.length;
        n = grid[0].length;
        int empty = 1, sx = 0, sy = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    empty++;
                else if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                }
            }
        }
        helper(sx, sy, empty);
        return res;
    }
    int res = 0, m = 0, n = 0;;
    int[][] g;
    int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};
    
    private void helper(int x, int y, int count) {
        if (x < 0 || x >= m || y < 0 || y >= n || g[x][y] == -1)
            return;
        if (g[x][y] == 2) {
            if (count == 0) res++;
            return;
        }
            
        g[x][y] = -1;
        for (int i = 0; i < 4; i++)
            helper(x + dx[i], y + dy[i], count - 1);
        g[x][y] = 0;
    }
}