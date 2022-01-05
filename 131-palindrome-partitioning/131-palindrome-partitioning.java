class Solution {
    public List<List<String>> partition(String s) {
        boolean[][] isPal = calcPal(s);
        List<List<String>> res = new ArrayList<List<String>>();
        helper(s, 0, res, new ArrayList<String>(), isPal);
        return res;
    }
    
    private void helper(String s, int start, List<List<String>> res, List<String> sol, boolean[][] isPal) {
        if (start == s.length()) {
            res.add(new ArrayList<String>(sol));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPal[start][i]) {
                sol.add(s.substring(start, i + 1));
                helper(s, i + 1, res, sol, isPal);
                sol.remove(sol.size() - 1);
            }
        }
    }
    
    private boolean[][] calcPal(String s) {
        int n = s.length();
        boolean[][] res = new boolean[n][n];
        for (int i = 0; i < n; i++)
            res[i][i] = true;
        for (int i = 0; i < n - 1; i++)
            res[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        for (int l = 2; l < n; l++) {
            for (int i = 0; i + l < n; i++) {
                res[i][i + l] = res[i+1][i+l-1] && (s.charAt(i) == s.charAt(i + l));
            }
        }
        return res;
    }
}