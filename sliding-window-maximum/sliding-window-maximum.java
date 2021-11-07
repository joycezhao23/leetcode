class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int n = nums.length, i = 0;
        int[] res = new int[n - k + 1];
        while (i < k) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            i++;
        }
        res[0] = map.lastKey();
        for (; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            int first = nums[i - k];
            map.put(first, map.get(first) - 1);
            if (map.get(first) == 0)
                map.remove(first);
            res[i - k + 1] = map.lastKey();
        }
        return res;
    }
}