class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] swaps) {
        int n = source.length, count = 0;
        int[] parents = getParents(n, swaps);
        Map<Integer, Map<Integer, Integer>> unions = getUnions(n, parents, source);
        for (int i = 0; i < n; i++) {
            int p = find(i, parents);
            Map<Integer, Integer> map = unions.get(p);
            if (map.getOrDefault(target[i], 0) == 0) {
                count++;
            } else {
                map.put(target[i], map.get(target[i]) - 1);
            }
        }
        return count;
    }
    
    private Map<Integer, Map<Integer, Integer>> getUnions(int n, int[] parents, int[] source) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int p = find(i, parents);
            map.putIfAbsent(p, new HashMap<Integer, Integer>());
            Map<Integer, Integer> count = map.get(p);
            count.put(source[i], count.getOrDefault(source[i], 0) + 1);
        }
        return map;
    }
    
    private int[] getParents(int n, int[][] swaps) {
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) parents[i] = i;
        for (int[] swap : swaps) {
            int p0 = find(swap[0], parents), p1 = find(swap[1], parents);
            if (p0 != p1) parents[p0] = p1;
        }
        return parents;
    }
    
    private int find(int x, int[] parents) {
        if (x == parents[x])
            return x;
        return parents[x] = find(parents[x], parents);
    }
}