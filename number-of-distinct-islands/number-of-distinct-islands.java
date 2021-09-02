class Solution {
    public int numDistinctIslands(int[][] grid) {
        Set<String> islands = new HashSet<String>();
        rows = grid.length;
        cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0)
                    continue;
                islands.add(bfs(grid, i, j));
            }
        }
        return islands.size();
    }
    
    int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};
    int rows = 0, cols = 0;
    
    private String bfs(int[][] grid, int x, int y) {
        List<int[]> ls = new ArrayList<int[]>();
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{x, y});
        grid[x][y] = 0;
        ls.add(new int[]{x, y});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int xx = cur[0] + dx[i], yy = cur[1] + dy[i];
                if (isValid(xx, yy) && grid[xx][yy] == 1) {
                    int[] pos = new int[]{xx, yy};
                    q.add(pos);
                    grid[xx][yy] = 0;
                    ls.add(pos);
                }
            }
        }
        return getString(ls);
    }
    
    private String getString(List<int[]> ls) {
        Collections.sort(ls, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] base = ls.get(0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ls.size(); i++) {
            sb.append("(").append(ls.get(i)[0] - base[0]).append(",");
            sb.append(ls.get(i)[1] - base[1]).append(")");
        }
        return sb.toString();
    }
    
    private boolean isValid(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}