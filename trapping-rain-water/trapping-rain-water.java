class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1, res = 0;
        while (l < r) {
            while (l < r && height[l] <= height[l + 1])
                l++;
            while (l < r && height[r] <= height[r - 1])
                r--;
            if (l >= r) break;
            if (height[l] < height[r]) {
                int h = height[l];
                while (l < r && height[l] <= h) {
                    res += h - height[l++];
                }
                
            } else {
                int h = height[r];
                while (r > l && height[r] <= h)
                    res += h - height[r--];
            }
        }
        return res;
    }
}