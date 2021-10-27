class Solution {
    public int minSpaceWastedKResizing(int[] nums, int k) {
        int n = nums.length;
        return helper(nums, 0, k, new Integer[n][k + 1]);
    }
    
    private int helper(int[] nums, int start, int k, Integer[][] memo) {
        if (start == nums.length) return 0;
        if (k == -1) return 200000000;
        if (memo[start][k] != null) return memo[start][k];
        int max = 0, total = 0, res = Integer.MAX_VALUE;
        for (int i = start; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            total += nums[i];
            int waste = max * (i - start + 1) - total;
            res = Math.min(res, waste + helper(nums, i + 1, k - 1, memo));
        }
        return memo[start][k] = res;
    }
}