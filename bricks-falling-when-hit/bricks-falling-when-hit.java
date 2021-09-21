class Solution {
    int[] parent, size;
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int m = grid.length, n = grid[0].length;
        int total = m * n;
        parent = new int[total];
        size = new int[total];
        for (int i = 0; i < total; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        
        for (int[] hit : hits) {
            grid[hit[0]][hit[1]]--;
        }
        
        int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1) continue;
                for (int k = 0; k < 4; k++) {
                    int x = i + dx[k], y = j + dy[k];
                    if (valid(x, y, m, n) && grid[x][y] == 1) {
                        union(i * n + j, x * n + y);
                    }
                }
            }
        }
                
        int[] res = new int[hits.length];
        for (int i = hits.length - 1; i >= 0; i--) {
            int x = hits[i][0], y = hits[i][1];
            if (grid[x][y] != 0) continue;
            grid[x][y] = 1;
            int count = 0;
            boolean stable = false;
            for (int j = 0; j < 4; j++) {
                int xx = x + dx[j], yy = y + dy[j];
                if (valid(xx, yy, m, n) && grid[xx][yy] == 1) {
                    int px = find(x * n + y), py = find(xx * n + yy);
                    if (px < n || py < n) stable = true;
                    if (px != py && py >= n) {
                        count += size[py];
                    }                    
                    union(px, py);    
                }
            }
            res[i] = stable ? count : 0;
        }
        return res;
    }
    
    private int find(int x) {
        if (parent[x] == x) 
            return x;
        return parent[x] = find(parent[x]);
    }
    
    private void union(int x, int y) {
        int px = find(x), py = find(y);
        if (px < py) {
            parent[py] = px;
            size[px] += size[py];
        } else if (px > py) {
            parent[px] = py;
            size[py] += size[px];
        }
    }
    
    private boolean valid(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}