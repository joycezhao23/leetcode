class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE, res = 0, n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = n - 1, t = target - nums[i];
            while (j < k) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }
                if (nums[j] + nums[k] == t) {
                    return target;
                }
                int d = Math.abs(nums[j] + nums[k] - t);
                if (d < diff) {
                    diff = d;
                    res = nums[i] + nums[j] + nums[k];
                }
                if (nums[j] + nums[k] < t) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res;
    }
}