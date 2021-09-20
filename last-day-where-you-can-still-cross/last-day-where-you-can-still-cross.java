class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int[] parent = new int[row * col + 2];
        int up = row * col, down = row * col + 1;
        for (int i = 0; i < row * col + 2; i++) 
            parent[i] = i;
        
        for (int i = 0; i < col; i++) {
            parent[i] = up;
            parent[up - i - 1] = down;
        }
        
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = 1;
            }
        }
        
        int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};
        for (int i = cells.length - 1; i >= 0; i--) {
            int x = cells[i][0] - 1, y = cells[i][1] - 1;
            matrix[x][y] = 0;
            for (int j = 0; j < 4; j++) {
                int xx = x + dx[j], yy = y + dy[j];
                if (valid(xx, yy, row, col) && matrix[xx][yy] == 0) {
                    int p1 = find(parent, x * col + y), p2 = find(parent, xx * col + yy);
                    if (p1 != p2) {
                        parent[p1] = p2;
                        if (find(parent, up) == find(parent, down)) return i;
                    }
                }
            }
        }
        
        return 0;
        
    }
    
    private boolean valid(int x, int y, int row, int col) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }
    
    private int find(int[] parent, int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent, parent[x]);
    }
}