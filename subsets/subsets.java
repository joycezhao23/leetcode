class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int n = nums.length, count = (1 << n);
        for (int i = 0; i < count; i++) {
            List<Integer> sol = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) sol.add(nums[j]);
            }
            res.add(sol);
        }
        return res;
    }
}