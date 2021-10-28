class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        Set<Integer> set = new HashSet<Integer>();
        set.add(0);
        int count = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (set.contains(sum - target)) {
                count++;
                sum = 0;
                set.clear();
                set.add(0);
            } else {
                set.add(sum);
            }
        }
        return count;
    }
}