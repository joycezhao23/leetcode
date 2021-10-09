class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> sol = new ArrayList<Integer>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) 
                    sol.add(nums[j]);
            }
            res.add(sol);
        }
        return res;
    }
}