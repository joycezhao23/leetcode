class Solution {
    class P {
        int count, loc;
        public P(int count, int loc) {
            this.count = count;
            this.loc = loc;
        }
    }
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<P> pq = new PriorityQueue<P>(2 * trips.length, (a, b) -> a.loc == b.loc ? a.count - b.count : a.loc - b.loc);
        for (int[] trip : trips) {
            pq.add(new P(trip[0], trip[1]));
            pq.add(new P(-trip[0], trip[2]));
        }
        int total = 0;
        while (!pq.isEmpty()) {
            total += pq.poll().count;
            if (total > capacity)
                return false;
        }
        return true;
    }
}