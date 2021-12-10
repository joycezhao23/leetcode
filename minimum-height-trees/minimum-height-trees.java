class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> leaves = new ArrayList<Integer>();
        if (n == 1) {
            leaves.add(0);
            return leaves;
        }
        Set<Integer>[] neighbors = new HashSet[n];
        for (int i = 0; i < n; i++)
            neighbors[i] = new HashSet<Integer>();
        for (int[] e : edges) {
            neighbors[e[0]].add(e[1]);
            neighbors[e[1]].add(e[0]);
        }
        
        for (int i = 0; i < n; i++) {
            if (neighbors[i].size() == 1) {
                leaves.add(i);
            }
        }
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<Integer>();
            for (int i : leaves) {
                int j = neighbors[i].iterator().next();
                neighbors[j].remove(i);
                if (neighbors[j].size() == 1) 
                    newLeaves.add(j);
            }
            leaves = newLeaves;
        }
        return leaves;        
    }
}