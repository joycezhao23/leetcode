class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) arr[i] = new int[]{quality[i], wage[i]};
        Arrays.sort(arr, (a, b) -> a[1] * b[0] - a[0] * b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, (a, b) -> b - a);
        double res = Double.MAX_VALUE;
        double sum = 0;
        
        for (int[] p : arr) {
            pq.add(p[0]);
            sum += p[0];
            if (pq.size() > k) sum -= pq.poll();
            if (pq.size() == k) res = Math.min(res, sum * (double)p[1] / p[0]);
        }
        
        return res;
    }
}