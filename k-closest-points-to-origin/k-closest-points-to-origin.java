class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<int[]>(k + 1, (a, b) -> (b[0] * b[0] + b[1] * b[1] - (a[0] * a[0] + a[1] * a[1])));
        for (int[] p : points) {
            q.add(p);
            if (q.size() > k)
                q.poll();
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) 
            res[i] = q.poll();
        return res;
    }
}