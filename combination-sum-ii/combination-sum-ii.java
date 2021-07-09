class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(candidates, target, 0, res, new ArrayList<Integer>());
        return res;
    }
    
    private void helper(int[] candidates, int target, int pos, List<List<Integer>> res, List<Integer> sol) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(sol));
            return;
        }
        
        for (int i = pos; i < candidates.length; i++) {
            if (i > pos && candidates[i] == candidates[i - 1]) continue;
            if (target - candidates[i] < 0) break;
            
            sol.add(candidates[i]);
            helper(candidates, target - candidates[i], i + 1, res, sol);
            sol.remove(sol.size() - 1);
        }
    }
}