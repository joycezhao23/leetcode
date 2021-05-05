class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1, total = 0, n = height.length;
        while (l < r) {
            while (l < n - 1 && height[l] <= height[l + 1]) l++;
            while (r > 0 && height[r] <= height[r - 1]) r--;
            if (l >= r) break;
            
            int h = Math.min(height[r], height[l]);
            if (height[l] <= height[r]) {
                while (l < r && height[l] <= h) {
                    total += h - height[l++];
                }
            } else {
                while (l < r && height[r] <= h) {
                    total += h - height[r--];
                }
            }
        }
        return total;
    }
}