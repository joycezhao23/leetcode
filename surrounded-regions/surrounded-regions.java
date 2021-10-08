class Solution {
    int m, n;
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        if (m < 3 || n < 3) return;
        for (int i = 0; i < n; i++) {
            dfs(0, i, board);
            dfs(m - 1, i, board);
        }
        for (int j = 1; j < m - 1; j++) {
            dfs(j, 0, board);
            dfs(j, n - 1, board);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }
    
    int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};
    private void dfs(int x, int y, char[][] b) {
        if (b[x][y] != 'O') return;
        b[x][y] = '.';
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i], yy = y + dy[i];
            if (xx < 0 || xx >= m || yy < 0 || yy >= n) continue;
            dfs(xx, yy, b);
        }
    }
}