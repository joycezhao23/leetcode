class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0, m = grid.length, n = grid[0].length;
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<int[]>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) continue;
                visited[i][j] = true;
                q.add(new int[]{i, j});
                int count = 0;
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    if (grid[cur[0]][cur[1]] == 0) continue;
                    count++;
                    for (int k = 0; k < 4; k++) {
                        int x = cur[0] + dx[k], y = cur[1] + dy[k];
                        if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) continue;
                        q.add(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
                res = Math.max(count, res);
            }
        }
        return res;        
    }
}