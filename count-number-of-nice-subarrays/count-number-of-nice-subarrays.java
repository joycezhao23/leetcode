class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
    
    private int atMost(int[] nums, int k) {
        if (k < 0) return 0;
        int count = 0, i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] % 2 == 1) k--;
            while (k < 0) {
                if (nums[i++] % 2 == 1) k++;
            }
            count += j - i + 1;
        }
        return count;
    }
}