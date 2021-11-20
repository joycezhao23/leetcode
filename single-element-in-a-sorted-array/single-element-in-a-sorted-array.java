class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1 || nums[0] != nums[1]) return nums[0];
        int l = 2, r = nums.length - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (mid % 2 == 1 && nums[mid] == nums[mid - 1] || mid % 2 == 0 && nums[mid] == nums[mid + 1]) {
                l = mid;
            } else {
                r = mid;
            }
        }
        if (nums[l] != nums[l - 1] && (l == nums.length - 1 || nums[l] != nums[l + 1]))
            return nums[l];
        return nums[r];
    }
}