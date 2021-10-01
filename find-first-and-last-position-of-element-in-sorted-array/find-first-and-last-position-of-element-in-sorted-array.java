class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        int n = nums.length, l = 0, r = n - 1;
        if (n == 0) return res;
        
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid;
            }
        }
        
        if (nums[l] != target && nums[r] != target) return res;
        res[0] = nums[l] == target ? l : r;
        r = n - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target) {
                r = mid;
            } else {
                l = mid;
            }
        }
        res[1] = nums[r] == target ? r : l;
        return res;
    }
}