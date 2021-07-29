class Solution {
    class Pair {
        int idx;
        int[] task;
        public Pair(int idx, int[] task) {
            this.idx = idx;
            this.task = task;
        }
    }
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) pairs[i] = new Pair(i, tasks[i]);
        Arrays.sort(pairs, (a, b) -> a.task[0] - b.task[0]);
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> a.task[1] == b.task[1] ? a.idx - b.idx : a.task[1] - b.task[1]);
        
        int i = 0, cur = 1, j = 0;
        int[] res = new int[n];
        
        while (j < n) {
            while (i < n && pairs[i].task[0] <= cur) {
                pq.add(pairs[i++]);
            }
            if (!pq.isEmpty()) {
                Pair p = pq.poll();
                res[j++] = p.idx;
                cur += p.task[1];
            }
            if (pq.isEmpty() && i < n) cur = Math.max(cur, pairs[i].task[0]);
        }
        
        return res;
    }
}