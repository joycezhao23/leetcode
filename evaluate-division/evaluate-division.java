class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            res[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<String>(), graph);
        }
        return res;
    }
    
    private double dfs(String start, String end, Set<String> visited, Map<String, Map<String, Double>> graph) {
        if (!graph.containsKey(start)) return -1.0;
        if (graph.get(start).containsKey(end))
            return graph.get(start).get(end);
        
        visited.add(start);
        for (Map.Entry<String, Double> entry : graph.get(start).entrySet()) {
            String key = entry.getKey();
            double val = entry.getValue();
            if (visited.contains(key)) continue;
            double next = dfs(key, end, visited, graph);
            if (next >= 0) return val * next;
        }
        return -1.0;
    }
    
    private Map<String, Map<String, Double>> buildGraph(List<List<String>>equations, double[] values) {
        Map<String, Map<String, Double>> map = new HashMap<String, Map<String, Double>>();
        for (int i = 0; i < values.length; i++) {
            String s1 = equations.get(i).get(0), s2 = equations.get(i).get(1);
            map.putIfAbsent(s1, new HashMap<String, Double>());
            map.putIfAbsent(s2, new HashMap<String, Double>());
            map.get(s1).put(s2, values[i]);
            map.get(s2).put(s1, 1 / values[i]);
        }
        return map;
    }
}