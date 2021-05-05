class Solution {
    public int jump(int[] nums) {
        int end = 0, farthest = 0, count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (end == i) {
                count++;
                end = farthest;
            }
        }
        return count;
    }
}