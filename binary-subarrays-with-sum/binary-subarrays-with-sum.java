class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }
    
    private int atMost(int[] nums, int t) {
        if (t < 0) return 0;
        int l = 0, sum = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum > t) {
                sum -= nums[l++]; 
            }
            res += i - l + 1;
        }
        return res;
    }
}