class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        
        int l = 1, r = max;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (getTotal(nums, mid) <= threshold) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    
    private int getTotal(int[] nums, int d) {
        int total = 0;
        for (int n : nums) {
            total += (n + d - 1) / d;
        }
        return total;
    }
}