class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(nums, 0, res, new ArrayList<Integer>());
        return res;
    }
    
    private void helper(int[] nums, int pos, List<List<Integer>> res, List<Integer> sol) {
        if (pos == nums.length) {
            if (sol.size() > 1) res.add(new ArrayList<Integer>(sol));
            return;
        }
        
        if (sol.size() == 0 || nums[pos] >= sol.get(sol.size() - 1)) {
            sol.add(nums[pos]);
            helper(nums, pos + 1, res, sol);
            sol.remove(sol.size() - 1);
        }
        
        if (sol.size() > 0 && nums[pos] == sol.get(sol.size() - 1)) {
            return;
        }
        
        helper(nums, pos + 1, res, sol);
    }
}