class Solution {
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') dfs(i, 0, board);
            if (board[i][n - 1] == 'O') dfs(i, n - 1, board);
        }
        for (int i = 1; i < n - 1; i++) {
            if (board[0][i] == 'O') dfs(0, i, board);
            if (board[m - 1][i] == 'O') dfs(m - 1, i, board);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }
    int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};
    int m, n;
    
    private void dfs(int x, int y, char[][] board) {
        board[x][y] = '.';
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i], yy = y + dy[i];
            if (xx < 0 || xx >= m || yy < 0 || yy >= n || board[xx][yy] != 'O')
                continue;
            dfs(xx, yy, board);
        }
    }
}