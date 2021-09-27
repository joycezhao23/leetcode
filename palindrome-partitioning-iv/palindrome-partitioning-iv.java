class Solution {
    public boolean checkPartitioning(String s) {
        int n = s.length();
        boolean[][] memo = new boolean[n][n];
        for (int i = 0; i < n; i++) memo[i][i] = true;
        for (int i = 0; i < n - 1; i++) memo[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        for (int l = 2; l < n; l++) {
            for (int i = 0; i + l < n; i++) {
                memo[i][i + l] = s.charAt(i) == s.charAt(i + l) && memo[i+1][i+l-1];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (memo[0][i] && memo[i + 1][j] && memo[j + 1][n - 1]) return true;
            }
        }        
        
        return false;
    }
}