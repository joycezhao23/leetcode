class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(nums, 0, res, new ArrayList<Integer>());
        return res;
    }
    
    private void helper(int[] nums, int pos, List<List<Integer>> res, List<Integer> sol) {
        res.add(new ArrayList<Integer>(sol));
        if (pos == nums.length) return;
        
        for (int i = pos; i < nums.length; i++) {
            if (i > pos && nums[i] == nums[i - 1]) continue;
            sol.add(nums[i]);
            helper(nums, i + 1, res, sol);
            sol.remove(sol.size() - 1);
        }
    }
}