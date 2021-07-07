class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0, min = 0, res = Integer.MIN_VALUE;
        for (int i : nums) {
            sum += i;
            res = Math.max(res, sum - min);
            min = Math.min(min, sum);
        }
        return res;
    }
}