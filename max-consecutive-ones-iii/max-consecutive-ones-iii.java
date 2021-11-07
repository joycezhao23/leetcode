class Solution {
    public int longestOnes(int[] nums, int k) {
        int max = 0, l = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                k--;
                if (k < 0) {
                    while (nums[l] != 0) {
                        l++;
                    }
                    l++;
                    k++;
                }
            }
            max = Math.max(max, i - l + 1);
        }
        return max;
    }
}