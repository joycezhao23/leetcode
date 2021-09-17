class Solution {
    public int minFlips(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int total = m * n, count = 0, num = 0, k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                num += mat[i][j] << k++;
            }
        }
        Set<Integer> seen = new HashSet<Integer>();
        seen.add(num);
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(num);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur = q.poll();
                if (cur == 0) return count;
                for (int i = 0; i < total; i++) {
                    int next = convert(cur, i, m, n);
                    if (seen.contains(next)) continue;
                    seen.add(next);
                    q.add(next);
                }
            }
            count++;
        }
        return -1;
    }
    
    private int convert(int cur, int idx, int m, int n) {
        int next = cur ^ (1 << idx);
        if (idx - n >= 0) next ^= (1 << (idx - n));
        if (idx + n < m * n) next ^= (1 << (idx + n));
        if (idx % n > 0) next ^= (1 << (idx - 1));
        if (idx % n < n - 1) next ^= (1 << (idx + 1));
        return next;
    }
}