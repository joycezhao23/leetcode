class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] steps = new int[n];
        Arrays.fill(steps, Integer.MAX_VALUE);
        steps[0] = 0;
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < Math.min(nums[i] + i + 1, n); j++) {
                steps[j] = Math.min(steps[j], steps[i] + 1);
            }
        }
        return steps[n - 1];
    }   
}