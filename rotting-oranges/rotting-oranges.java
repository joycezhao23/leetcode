class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<int[]>();
        int oranges = 0, m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    continue;
                if (grid[i][j] == 2)
                    q.add(new int[]{i, j});
                oranges++;
            }
        }
        int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};
        int minute = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                oranges--;
                for (int i = 0; i < 4; i++) {
                    int x = cur[0] + dx[i], y = cur[1] + dy[i];
                    if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 1)
                        continue;
                    grid[x][y] = 2;
                    q.add(new int[]{x, y});
                }
            }
            minute++;
        }
        return oranges == 0 ? Math.max(0, minute) : -1;
    }
}