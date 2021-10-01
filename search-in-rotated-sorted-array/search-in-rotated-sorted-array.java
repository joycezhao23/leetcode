class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, last = nums[r];
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= last) {
                if (nums[mid] < target && target <= last) {
                    l = mid;
                } else {
                    r = mid;
                }
            } else {
                if (nums[mid] > target && target > last) {
                    r = mid;
                } else {
                    l = mid;
                }
            }
        }
        if (nums[l] == target) return l;
        if (nums[r] == target) return r;
        return -1;
    }
}