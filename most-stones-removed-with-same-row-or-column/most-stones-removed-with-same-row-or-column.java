class Solution {
    Map<Integer, Integer> p = new HashMap<Integer, Integer>();
    int islands = 0;
    
    public int removeStones(int[][] stones) {
        for (int[] stone : stones) {
            union(stone[0], ~stone[1]);
        }
        return stones.length - islands;
    }
    
    private int find(int a) {
        if (!p.containsKey(a)) {
            p.put(a, a);
            islands++;
        }
        if (p.get(a) != a) {
            p.put(a, find(p.get(a)));
        }
        return p.get(a);
    }
    
    private void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            p.put(a, b);
            islands--;
        }
    }
}