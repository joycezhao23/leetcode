class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length, res = n + 1, sum = 0, lo = 0;
        
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum >= target) {
                while (lo < i && sum - nums[lo] >= target) {
                    sum -= nums[lo];
                    lo++;
                }
                res = Math.min(res, i - lo + 1);
            }
        }
        
        return res == n + 1 ? 0 : res;
    }
}