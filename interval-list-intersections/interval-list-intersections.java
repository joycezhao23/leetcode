class Solution {
    class TS {
        int time, start;
        public TS(int time, int start) {
            this.time = time;
            this.start = start;
        }
    }
    
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        PriorityQueue<TS> pq = new PriorityQueue<TS>(firstList.length + secondList.length, (a, b) -> a.time == b.time ? a.start - b.start : a.time - b.time);
        
        for (int[] t : firstList) {
            pq.add(new TS(t[0], -1));
            pq.add(new TS(t[1], 0));
        }
        
        for (int[] t : secondList) {
            pq.add(new TS(t[0], -1));
            pq.add(new TS(t[1], 0));
        }
        
        List<int[]> res = new ArrayList<>();
        int count = 0, s = -1;
        while (!pq.isEmpty()) {
            TS t = pq.poll();
            if (t.start == -1) {
                count++;
                if (count == 2) s= t.time;
            } else {
                count--;
                if (count == 1) {
                    int[] itv = {s, t.time};
                    res.add(itv);
                }
            }
        }
        int[][] rst = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            rst[i][0] = res.get(i)[0];
            rst[i][1] = res.get(i)[1];
        }
        return rst;
    }
}