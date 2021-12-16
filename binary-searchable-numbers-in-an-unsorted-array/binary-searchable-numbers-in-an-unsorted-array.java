class Solution {
    public int binarySearchableNumbers(int[] nums) {
        int n = nums.length;
        int[] mins = new int[n], maxs = new int[n];
        mins[n - 1] = Integer.MAX_VALUE;
        maxs[0] = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            maxs[i] = Math.max(maxs[i - 1], nums[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            mins[i] = Math.min(mins[i + 1], nums[i + 1]);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (maxs[i] < nums[i] && nums[i] < mins[i]) 
                count++;
        }
        return count;
    }
}