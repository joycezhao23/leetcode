class Solution {
    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int[] parents = new int[rows * cols];
        int[] dx = new int[]{0, -1};
        int[] dy = new int[]{-1, 0};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '0')
                    continue;
                int idx = convert1d(i, j);
                parents[idx] = idx;
                count++;
                for (int k = 0; k < 2; k++) {
                    int x = i + dx[k], y = j + dy[k];
                    if (!isValid(x, y, grid))
                        continue;
                    union(parents, idx, convert1d(x, y));
                }
            }
        }
        return count;
    }
    
    int count = 0;
    int rows = 0, cols = 0;
    
    private int find(int[] parents, int x) {
        if (parents[x] == x)
            return x;
        return parents[x] = find(parents, parents[x]);
    }
    
    private void union(int[] parents, int x, int y) {
        int px = find(parents, x), py = find(parents, y);
        if (px != py) {
            count--;
            parents[px] = py;
        }
    }
    
    private int convert1d(int x, int y) {
        return x * cols + y;
    }
    
    private boolean isValid(int x, int y, char[][] grid) {
        return x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == '1';
    }
}