class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(1, n, k, res, new ArrayList<Integer>());
        return res;
    }
    
    private void helper(int start, int target, int count, List<List<Integer>> res, List<Integer> sol) {
        if (target == 0 && count == 0) {
            res.add(new ArrayList<Integer>(sol));
            return;
        }
        if (target <= 0 || count == 0) return;
        
        for (int i = start; i <= 9; i++) {
            sol.add(i);
            helper(i + 1, target - i, count - 1, res, sol);
            sol.remove(sol.size() - 1);
        }
    }
}