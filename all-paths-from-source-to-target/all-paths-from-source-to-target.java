class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        g = graph;
        n = graph.length;
        List<List<Integer>> res = helper(0, new HashMap<Integer, List<List<Integer>>>());
        for (List<Integer> sol : res) {
            Collections.reverse(sol);
        }
        return res;
    }
    int[][] g;
    int n;
    
    private List<List<Integer>> helper(int start, Map<Integer, List<List<Integer>>> map) {
        if (map.containsKey(start))
            return map.get(start);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (start == n -1) {
            List<Integer> sol = new ArrayList<Integer>();
            sol.add(start);
            res.add(sol);
            map.put(start, res);
            return res;
        }
        for (int next : g[start]) {
            List<List<Integer>> list = helper(next, map);
            for (List<Integer> l : list) {
                List<Integer> sol = new ArrayList<Integer>(l);
                sol.add(start);
                res.add(sol);
            }
        }
        map.put(start, res);
        return res;        
    }
}