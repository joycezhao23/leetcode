class Solution {
    public int totalFruit(int[] tree) {
        int sum = 0, res = 0, l = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < tree.length; i++) {
            map.put(tree[i], map.getOrDefault(tree[i], 0) + 1);
            sum++;
            while (map.size() > 2) {
                map.put(tree[l], map.get(tree[l]) - 1);
                map.remove(tree[l++], 0);
                sum--;
            }
            res = Math.max(res, sum);
        }
        
        return res;
    }
}