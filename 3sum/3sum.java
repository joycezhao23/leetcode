class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (n < 3) return res;
        
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = n - 1, target = 0 - nums[i];
            while (l < r) {
                if (nums[l] + nums[r] == target) {
                    List<Integer> sol = new ArrayList<Integer>();
                    sol.add(nums[i]);
                    sol.add(nums[l]);
                    sol.add(nums[r]);
                    res.add(sol);
                    while (l < n - 1 && nums[l] == nums[l + 1]) l++;
                    while (r > 0 && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if (nums[l] + nums[r] < target) {
                    while (l < n - 1 && nums[l] == nums[l + 1]) l++;
                    l++;
                } else {
                    while (r > 0 && nums[r] == nums[r - 1]) r--;
                    r--;
                }
            }
        }
        return res;
    }
}