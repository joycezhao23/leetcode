class Solution {
    int m, n;
    int[][] h;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        h = heights;
        boolean[][][] canFlow = new boolean[m][n][2];
        for (int i = 0; i < m; i++) {
            dfs(i, 0, 0, canFlow);
            dfs(i, n - 1, 1, canFlow);
        }
        for (int i = 0; i < n; i++) {
            dfs(0, i, 0, canFlow);
            dfs(m - 1, i, 1, canFlow);
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canFlow[i][j][0] && canFlow[i][j][1]) {
                    List<Integer> sol = new ArrayList<Integer>();
                    sol.add(i);
                    sol.add(j);
                    res.add(sol);
                }
            }
        }
        return res;
    }
    
    int[] dx = {0, 1, 0, -1}, dy = {1,0,-1,0};
    private void dfs(int x, int y, int ocean, boolean[][][] canFlow) {
        canFlow[x][y][ocean] = true;
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i], yy = y + dy[i];
            if (xx < 0 || xx >= m || yy < 0 || yy >= n || h[xx][yy] < h[x][y] || canFlow[xx][yy][ocean])
                continue;
            dfs(xx, yy, ocean, canFlow);
        }
    }
}