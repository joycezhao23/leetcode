class Solution {
    class Pair {
        int profit, capital;
        public Pair(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) pairs[i] = new Pair(profits[i], capital[i]);
        Arrays.sort(pairs, (a, b) -> a.capital == b.capital ? b.profit - a.profit : a.capital - b.capital);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        int res = w, idx = 0;
        while (k > 0) {
            while (idx < n && pairs[idx].capital <= res) {
                pq.add(pairs[idx++].profit);
            }
            if (pq.isEmpty()) break;
            int profit = pq.poll();
            res += profit;
            k--;
        }
        return res;
    }
}