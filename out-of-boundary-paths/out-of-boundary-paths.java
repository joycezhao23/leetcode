class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if (maxMove == 0) return 0;
        int[][] count = new int[m][n];
        count[startRow][startColumn] = 1;
        int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};
        int result = 0, MOD = 1000000007;
        
        for (int step = 0; step < maxMove; step++) {
            int[][] tmp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k], y = j + dy[k];
                        if (x < 0 || x >= m || y < 0 || y >= n) {
                            result = (result + count[i][j]) % MOD;
                        } else {
                            tmp[x][y] = (tmp[x][y] + count[i][j]) % MOD;
                        }
                    }
                }
            }
            count = tmp;
        }
        return result;
    }
}