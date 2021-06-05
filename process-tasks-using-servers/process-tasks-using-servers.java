class Solution {
    class Pair {
        int w, idx;
        public Pair(int weight, int index) {
            w = weight;
            idx = index;
        }
    }
    class TimePair {
        int t;
        Pair p;
        public TimePair(int time, Pair pair) {
            t = time;
            p = pair;
        }
    }
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<Pair> freeServers = new PriorityQueue<Pair>((a,b) -> a.w == b.w ? a.idx - b.idx : a.w - b.w);
        for (int i = 0; i < servers.length; i++) {
            freeServers.add(new Pair(servers[i], i));
        }
        
        int n = tasks.length, time = 0, i = 0;
        int[] res = new int[n];
        PriorityQueue<TimePair> busyServers = new PriorityQueue<TimePair>((a, b) -> a.t - b.t);
        
        while (i < n) {
            while (busyServers.size() > 0 && busyServers.peek().t <= time) {
                TimePair e = busyServers.poll();
                time = e.t;
                freeServers.add(e.p);
            }
            while (i < n && i <= time && freeServers.size() > 0) {
                Pair free = freeServers.poll();
                busyServers.add(new TimePair(time + tasks[i], free));    
                res[i++] = free.idx;
            }
            time = freeServers.size() == 0 ? busyServers.peek().t : i;
        }
        return res;
    }
}