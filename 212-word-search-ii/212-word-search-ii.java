class Solution {
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        public TrieNode() {
            this.children = new TrieNode[128];
            this.isWord = false;
        }
    }
    
    TrieNode root;
    
    public List<String> findWords(char[][] board, String[] words) {
        this.root = new TrieNode();
        for (String s : words) add(s);
        m = board.length;
        n = board[0].length;
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                dfs(board, i, j, res, root, new StringBuilder());        
        }        
        return res;
    }
    
    int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};
    int m, n;
    
    private void dfs(char[][] board, int x, int y, List<String> res, TrieNode cur, StringBuilder sb) {
        if (cur.isWord) {
            res.add(sb.toString());
            cur.isWord = false;
        }
        if (!isValid(x, y) || board[x][y] == 0) return;
        char c = board[x][y];
        if (cur.children[c] == null) return;
        sb.append(c);
        board[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i], yy = y + dy[i];
            dfs(board, xx, yy, res, cur.children[c], sb);
        }
        board[x][y] = c;
        sb.deleteCharAt(sb.length() - 1);
    }
    
    
    private boolean isValid(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;    
    }
    
    private void add(String s) {
        TrieNode cur = root;
        for (char c : s.toCharArray()) {
            if (cur.children[c] == null)
                cur.children[c] = new TrieNode();
            cur = cur.children[c];
        }
        cur.isWord = true;
    }
}