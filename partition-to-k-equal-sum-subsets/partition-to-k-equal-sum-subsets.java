class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = getTotal(nums);
        if (total % k != 0) return false;
        Arrays.sort(nums);
        return helper(nums, k, 0, 0, total / k, new HashSet<Integer>());
    }
    
    private boolean helper(int[] nums, int k, int idx, int cur, int target, Set<Integer> used) {
        if (k == 0) return true;
        
        if (cur == target) {
            return helper(nums, k - 1, 0, 0, target, used);
        }
        
        for (int i = idx; i < nums.length; i++) {
            if (used.contains(i)) continue;
            if (cur + nums[i] > target) break;
            used.add(i);
            if (helper(nums, k, i + 1, cur + nums[i], target, used)) return true;
            used.remove(i);
        }
        
        return false;
    }
    
    private int getTotal(int[] nums) {
        int res = 0;
        for (int i : nums) res += i;
        return res;
    }
}