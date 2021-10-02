class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        if (nums.length < 3) return Math.min(nums[l], nums[r]);
        
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= nums[n - 1]) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return Math.min(nums[l], nums[r]);
    }
}