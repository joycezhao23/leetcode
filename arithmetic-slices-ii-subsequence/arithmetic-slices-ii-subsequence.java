class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        Map<Long, Integer>[] map = new HashMap[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            map[i] = new HashMap<Long, Integer>();
            for (int j = 0; j < i; j++) {
                long diff = (long)nums[i] - nums[j];
                int prev = map[j].getOrDefault(diff, 0);
                res += prev;
                map[i].put(diff, map[i].getOrDefault(diff, 0) + prev + 1);
            }
        }
        return res;
    }
}