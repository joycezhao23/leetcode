class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }
    
    private int atMost(int[] nums, int t) {
        if (t < 0) return 0;
        int res = 0, i = 0, sum = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum > t) {
                sum -= nums[i++];
            }
            res += j - i + 1;
        }
        return res;
    }
}