class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer>[] map = new HashMap[n];
        for (int i = 0; i < n; i++)
            map[i] = new HashMap<Integer, Integer>();
        int res = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int diff = nums[i] - nums[j];
                if (map[i].containsKey(diff)) continue;
                map[i].put(diff, map[j].getOrDefault(diff, 0) + 1);
                res = Math.max(res, map[i].get(diff));
            }
        }
        return res + 1;
    }
}