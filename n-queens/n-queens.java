class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[] cols = new boolean[n];
        boolean[] ds = new boolean[2 * n - 1];
        boolean[] ads = new boolean[2 * n - 1];
        List<List<String>> res = new ArrayList<List<String>>();
        helper(0, n, cols, ds, ads, new ArrayList<String>(), res);
        return res;
    }
    
    private void helper(int row, int n, boolean[] cols, boolean[] ds, boolean[] ads, List<String> sol, List<List<String>> res) {
        if (row == n) {
            res.add(new ArrayList<String>(sol));
            return;
        }
        
        for (int i = 0; i < n; i++) {
            int d = row - i + n - 1, ad = row + i;
            if (cols[i] || ds[d] || ads[ad]) continue;
            cols[i] = ds[d] = ads[ad] = true;
            sol.add(".".repeat(i) + "Q" + ".".repeat(n - 1 - i));
            helper(row + 1, n, cols, ds, ads, sol, res);
            sol.remove(sol.size() - 1);
            cols[i] = ds[d] = ads[ad] = false;
        }
    }
}