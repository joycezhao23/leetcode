class Solution {
    int obs = -1, gate = 0;
    int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};
    
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length, n = rooms[0].length, INF = 2147483647;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == gate) {
                    bfs(rooms, new boolean[m][n], i, j);
                }
            }
        }
    }
    
    private void bfs(int[][] rooms, boolean[][] visited, int x, int y) {
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        int dist = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                for (int i = 0; i < 4; i++) {
                    int xx = cur[0] + dx[i], yy = cur[1] + dy[i];
                    if (xx < 0 || xx >= rooms.length || yy < 0 || yy >= rooms[0].length || visited[xx][yy] || rooms[xx][yy] <= dist || rooms[xx][yy] == obs || rooms[xx][yy] == gate)
                        continue;
                    rooms[xx][yy] = dist;
                    q.add(new int[]{xx, yy});
                }
            }
            dist++;
        }
    }
}