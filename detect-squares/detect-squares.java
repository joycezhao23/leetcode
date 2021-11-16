class DetectSquares {
    Set<Integer>[] rows, cols;
    Map<Integer, Integer> counts;
    
    public DetectSquares() {
        rows = new Set[1001];
        cols = new Set[1001];
        for (int i = 0; i <= 1000; i++) {
            rows[i] = new HashSet<Integer>();
            cols[i] = new HashSet<Integer>();
        }
        counts = new HashMap<Integer, Integer>();
    }
    
    public void add(int[] point) {
        int p = point[0] * 1001 + point[1];
        counts.put(p, counts.getOrDefault(p, 0) + 1);
        rows[point[0]].add(p);
        cols[point[1]].add(p);
    }
    
    public int count(int[] point) {
        Set<Integer> row = rows[point[0]], col = cols[point[1]];
        int total = 0;
        for (int r : row) {
            for (int c : col) {
                int rc = r % 1001, rr = r / 1001, cc = c % 1001, cr = c / 1001;
                if (rc == cc || rr == cr || Math.abs(rc - cc) != Math.abs(rr - cr)) continue;
                int p = cr * 1001 + rc;
                total += counts.getOrDefault(p, 0) * counts.get(r) * counts.get(c);
            }
        }
        return total;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */