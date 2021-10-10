class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        helper(0, candidates, target, new ArrayList<Integer>(), res);
        return res;
    }
    
    private void helper(int idx, int[] nums, int target, List<Integer> sol, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(sol));
            return;
        }
        if (target < 0) return;
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) continue;
            sol.add(nums[i]);
            helper(i + 1, nums, target - nums[i], sol, res);
            sol.remove(sol.size() - 1);
        }
    }
}