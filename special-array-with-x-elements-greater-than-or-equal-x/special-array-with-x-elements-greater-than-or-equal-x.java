class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            if (i < n && nums[n - 1 - i] >= i) continue;
            if (i > 0 && nums[n - i] < i) continue;
            return i;
        }
        return -1;
    }
}