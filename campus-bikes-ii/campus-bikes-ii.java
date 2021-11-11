class Solution {
    class Pair {
        int state, cost;
        public Pair(int state, int cost) {
            this.state = state;
            this.cost = cost;
        }
    }
    
    public int assignBikes(int[][] workers, int[][] bikes) {
        int m = workers.length, n = bikes.length;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> a.cost - b.cost);
        pq.add(new Pair(0, 0));
        Set<Integer> seen = new HashSet<Integer>();
        
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
            }
        }
        
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            if (seen.contains(cur.state)) continue;
            seen.add(cur.state);
            int i = Integer.bitCount(cur.state);
            if (i == m) return cur.cost;
            
            for (int j = 0; j < n; j++) {
                if (((cur.state >> j) & 1) == 1) continue;
                int next = cur.state + (1 << j);
                if (seen.contains(next)) continue;
                pq.add(new Pair(next, cur.cost + dist[i][j]));
            }
        }
        return -1;
    }
}