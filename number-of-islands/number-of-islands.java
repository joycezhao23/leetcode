class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0')
                    continue;
                count++;
                bfs(grid, i, j);
            }
        }
        return count;
    }
    
    private void bfs(char[][] grid, int x, int y) {
        int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{x, y});
        grid[x][y] = '0';
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int xx = cur[0] + dx[i], yy = cur[1] + dy[i];
                if (isValid(grid, xx, yy)) {
                    grid[xx][yy] = '0';
                    q.add(new int[]{xx, yy});
                }
            }
        }
    }
    
    private boolean isValid(char[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1';
    }
}