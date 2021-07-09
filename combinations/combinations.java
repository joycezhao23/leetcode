class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(1, n, k, res, new ArrayList<Integer>());
        return res;
    }
    
    private void helper(int start, int n, int k, List<List<Integer>> res, List<Integer> sol) {
        if (k == 0) {
            res.add(new ArrayList<Integer>(sol));
            return;
        }
        
        for (int i = start; i <= n; i++) {
            if (n - i + 1 < k) break;
            sol.add(i);
            helper(i + 1, n, k - 1, res, sol);
            sol.remove(sol.size() - 1);
        }
    }
}