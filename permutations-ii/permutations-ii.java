class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Set<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            set.add(i);
        }
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(nums.length, set, map, res, new ArrayList<Integer>());
        return res;
    }
    
    private void helper(int n, Set<Integer> nums, Map<Integer, Integer> map, List<List<Integer>> res, List<Integer> sol) {
        if (sol.size() == n) {
            res.add(new ArrayList<Integer>(sol));
            return;
        }
        
        for (int num : nums) {
            if (map.get(num) == 0) continue;
            map.put(num, map.get(num) - 1);
            sol.add(num);
            helper(n, nums, map, res, sol);
            sol.remove(sol.size() - 1);
            map.put(num, map.get(num) + 1);
        }
    }
}