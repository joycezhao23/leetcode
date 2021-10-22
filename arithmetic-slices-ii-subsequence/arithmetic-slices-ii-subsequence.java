class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int res = 0, n = nums.length;
        Map<Long, Integer>[] map = new HashMap[n];
        for (int i = 0; i < n; i++) 
            map[i] = new HashMap<Long, Integer>();
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                long diff = (long)nums[i] - nums[j];
                int last = map[j].getOrDefault(diff, 0);
                res += last;
                map[i].put(diff, map[i].getOrDefault(diff, 0) + 1 + last);
            }
        }
        return res;
    }
}