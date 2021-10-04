class Solution {
    public int islandPerimeter(int[][] grid) {
        int res = 0, m = grid.length, n = grid[0].length;
        int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    continue;
                int connected = 0;
                for (int k = 0; k < 4; k++) {
                    int x = i + dx[k], y = j + dy[k];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1)
                        connected++;
                }                
                res += (4 - connected);
            }
        }
        return res;
    }
}