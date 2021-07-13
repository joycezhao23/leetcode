class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            helper(nums, i, res, new ArrayList<Integer>(), new HashSet<Integer>());    
        }
        return res;
    }
    
    private void helper(int[] nums, int pos, List<List<Integer>> res, List<Integer> sol, Set<Integer> visited) {        
        sol.add(nums[pos]);
        visited.add(nums[pos]);
        
        if (sol.size() == nums.length) {
            res.add(new ArrayList<Integer>(sol));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (visited.contains(nums[i])) continue;
                helper(nums, i, res, sol, visited);
            }    
        }
        
        sol.remove(sol.size() - 1);
        visited.remove(nums[pos]);
    }
}