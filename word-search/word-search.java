class Solution {
    public boolean exist(char[][] board, String word) {
        b = board;
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (helper(i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    char[][] b;
    int m, n;
    int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};
    
    private boolean helper(int x, int y, String word, int idx) {
        if (idx == word.length())
            return true;
        if (x < 0 || x >= m || y < 0 || y >= n || word.charAt(idx) != b[x][y])
            return false;
        b[x][y] = '.';
        boolean found = false;
        for (int i = 0; i < 4; i++) {
            if (helper(x + dx[i], y + dy[i], word, idx + 1)) {
                found = true;
                break;
            }
        }
        b[x][y] = word.charAt(idx);
        return found;
    }
}