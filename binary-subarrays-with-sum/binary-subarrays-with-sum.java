class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }
    
    private int atMost(int[] nums, int g) {
        if (g < 0) return 0;
        int res = 0, i = 0;
        for (int j = 0; j < nums.length; j++) {
            g -= nums[j];
            while (g < 0) {
                g += nums[i++];
            }
            res += j - i + 1;
        }
        return res;
    }
}