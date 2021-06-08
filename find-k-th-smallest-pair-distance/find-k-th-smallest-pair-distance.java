class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, l = 0, r = nums[n - 1] - nums[0];
        while (l < r) {
            int mid = l + (r - l) / 2, count = 0;
            for (int i = 0, j = 0; i < n; i++) {
                while (j < n && nums[i] + mid >= nums[j]) j++;
                count += j - i - 1;
            }
            if (count < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}