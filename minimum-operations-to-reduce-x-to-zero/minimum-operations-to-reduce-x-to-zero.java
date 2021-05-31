class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int[] psum = new int[n + 1];
        for (int i = 0; i < n; i++) psum[i + 1] = psum[i] + nums[i];
        if (psum[n] < x) return -1;
        if (psum[n] == x) return n;
        
        int target = psum[n] - x, maxL = 0, l = 0;
        for (int i = 1; i <= n; i++) {
            while (psum[i] - psum[l] > target) l++;
            if (psum[i] - psum[l] == target) maxL = Math.max(maxL, i - l);
        }
        return maxL == 0 ? -1 : n - maxL;
    }
}