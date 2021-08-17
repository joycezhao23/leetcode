class Solution {
    public int missingNumber(int[] nums) {
        int total = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            total += i + 1;
            sum += nums[i];
        }
        return total - sum;
    }
}