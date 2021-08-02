class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = speed[i];
            pairs[i][1] = efficiency[i];
        }
        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);
        int MOD = 1000000007;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);
        long sum = 0, res = 0;
        for (int[] pair : pairs) {
            pq.add(pair[0]);
            sum += pair[0];
            if (pq.size() > k) 
                sum -= pq.poll();
            res = Math.max(res, pair[1] * sum);
        }
        
        return (int)(res % MOD);
    } 
}