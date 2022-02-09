class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 0;
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (k == 0) {
                count += (e.getValue() > 1 ? 1 : 0);
            } else if (map.containsKey(e.getKey() + k)) {
                count++;
            }
        }
        return count;
    }
}