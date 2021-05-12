class Solution {
    public int totalFruit(int[] tree) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int res = 0, n = tree.length, lo = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(tree[i]) || map.size() < 2) {
                map.put(tree[i], map.getOrDefault(tree[i], 0) + 1);
            } else {
                res = Math.max(i - lo, res);
                while (map.size() == 2) {
                    int key = tree[lo++];
                    if (map.get(key) == 1) {
                        map.remove(key);
                    } else {
                        map.put(key, map.get(key) - 1);    
                    }
                }
                map.put(tree[i], 1);
            }
        }
        return Math.max(res, n - lo);
    }
}