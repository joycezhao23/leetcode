class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int res = 0, D = 100000, idx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for (int i = 1; i <= D; i++) {
            while (!pq.isEmpty() && pq.peek() < i) pq.poll();
            while (idx < events.length && events[idx][0] == i) {
                pq.add(events[idx++][1]);
            }
            if (!pq.isEmpty()) {
                pq.poll();
                res++;
            }
        }
        
        
        return res;
    }
}