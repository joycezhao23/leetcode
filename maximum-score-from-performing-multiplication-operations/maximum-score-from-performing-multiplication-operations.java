class Solution {
    int n, m;
    int[] nums, mul;
    public int maximumScore(int[] nums, int[] mul) {
        n = nums.length;
        m = mul.length;
        Integer[][] dp = new Integer[m][m];
        this.nums = nums;
        this.mul = mul;
        
        return helper(0, 0, dp);    
    }
    
    private int helper(int start, int count, Integer[][] memo) {
        if (count == m) return 0;
        if (memo[start][count] != null) return memo[start][count];
        int pickl = nums[start] * mul[count] + helper(start + 1, count + 1, memo);
        int pickr = nums[n + start - count - 1] * mul[count] + helper(start, count + 1, memo);
        return memo[start][count] = Math.max(pickl, pickr);
    }
}