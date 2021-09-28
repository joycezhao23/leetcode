class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length, sum = 0;
        for (int i : nums) sum += i;
        if (sum < target || (sum - target) % 2 != 0) return 0;
        int t = (sum - target) / 2;
        int[] dp = new int[t + 1];
        dp[0] = 1;
        for (int i : nums) {
            for (int j = t; j >= i; j--) {
                dp[j] += dp[j - i];
            }
        }
        return dp[t];
    }
}