class Solution {
    public boolean exist(char[][] board, String word) {
        this.board = board;
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (helper(i, j, 0, word)) 
                    return true;
            }
        }
        return false;
    }
    char[][] board;
    int m, n;
    int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};
    private boolean helper(int x, int y, int idx, String word) {
        if (idx == word.length()) return true;
        if (x < 0 || x >= m || y < 0 || y >= n) return false;
        if (board[x][y] != word.charAt(idx)) return false;
        char c = board[x][y];
        board[x][y] = '.';
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i], yy = y + dy[i];
            if (helper(xx, yy, idx + 1, word))
                return true;
        }
        board[x][y] = c;
        return false;
    }
}