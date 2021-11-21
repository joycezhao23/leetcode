class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<Map.Entry<Integer, Integer>>(k + 1, (a, b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            q.add(entry);
            if (q.size() > k) 
                q.poll();
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = q.poll().getKey();
        }
        return res;
    }
}