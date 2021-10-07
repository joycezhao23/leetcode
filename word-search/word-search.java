class Solution {
    char[][] b;
    int m, n;
    public boolean exist(char[][] board, String word) {
        b = board;
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (helper(i, j, 0, word)) return true;
            }
        }
        return false;
    }
    
    int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};
    private boolean helper(int x, int y, int idx, String word) {
        if (idx == word.length()) return true;
        if (x < 0 || x >= m || y < 0 || y >= n || b[x][y] != word.charAt(idx))
            return false;
        char c = b[x][y];
        b[x][y] = '0';
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i], yy = y + dy[i];
            if (helper(xx, yy, idx + 1, word)) {
                return true;   
            }
        }
        b[x][y] = c;
        return false;
    }
}