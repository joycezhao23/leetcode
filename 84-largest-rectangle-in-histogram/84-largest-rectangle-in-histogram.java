class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n], right = new int[n];
        left[0] = -1;
        for (int i = 1; i < n; i++) {
            int p = i - 1;
            while (p >= 0 && heights[p] >= heights[i])
                p = left[p];
            left[i] = p;
        }
        right[n - 1] = n;
        for (int i = n - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < n && heights[p] >= heights[i]) 
                p = right[p];
            right[i] = p;
        }
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            int rect = heights[i] * (right[i] - left[i] - 1);
            max = Math.max(max, rect);
        }
        return max;
    }
}