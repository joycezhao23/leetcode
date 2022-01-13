class Solution {
    class Node {
        List<Node> neighbors;
        int vertex;
        public Node(int vertex) {
            this.vertex = vertex;
            this.neighbors = new ArrayList<Node>();
        }
    }
    
    public double frogPosition(int n, int[][] edges, int t, int target) {
        Node node = build(n, edges);
        return helper(null, node, t, target, 1);
    }
    
    private double helper(Node prev, Node cur, int t, int target, double p) {
        if (t == 0) return cur.vertex == target ? p : 0;
        int nexts = cur.neighbors.size() - (prev == null ? 0 : 1);
        if (nexts == 0) return helper(prev, cur, t - 1, target, p);
        double pp = p * (1.0 / nexts);
        for (Node next : cur.neighbors) {
            if (prev != null && next.vertex == prev.vertex) continue;
            double prob = helper(cur, next, t - 1, target, pp);
            if (prob > 0) return prob;
        }
        return 0;
    }
    
    private Node build(int n, int[][] edges) {
        Node[] nodes = new Node[n + 1];
        nodes[1] = new Node(1);
        for (int[] e : edges) {
            if (nodes[e[0]] == null) nodes[e[0]] = new Node(e[0]);
            if (nodes[e[1]] == null) nodes[e[1]] = new Node(e[1]);
            nodes[e[0]].neighbors.add(nodes[e[1]]);
            nodes[e[1]].neighbors.add(nodes[e[0]]);
        }
        return nodes[1];
    }
}