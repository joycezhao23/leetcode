class ExamRoom {
    class Interval {
        int l, r, dist;
        public Interval(int left, int right) {
            l = left;
            r = right;
            if (left == -1) {
                dist = right;
            } else if (right == n) {
                dist = n - left - 1;
            } else {
                dist = (right - left) / 2;
            }
        }
        
        public boolean equals(Interval other) {
            return l == other.l && r == other.r;
        }
    }

    int n;
    TreeSet<Integer> seats;
    TreeSet<Interval> intervals;
    public ExamRoom(int N) {
        this.n = N;
        seats = new TreeSet<Integer>();
        intervals = new TreeSet<Interval>((a, b) -> a.dist == b.dist ? a.l - b.l : b.dist - a.dist);
        intervals.add(new Interval(-1, n));
    }
    
    public int seat() {
        Interval itv = intervals.pollFirst();
        int pos = -1;
        if (itv.l == -1) {
            pos = 0;
            intervals.add(new Interval(0, itv.r));
        } else if (itv.r == n) {
            pos = n - 1;
            intervals.add(new Interval(itv.l, n - 1));
        } else {
            pos = itv.l + (itv.r - itv.l) / 2;
            intervals.add(new Interval(pos, itv.r));
            intervals.add(new Interval(itv.l, pos));
        }
        seats.add(pos);
        return pos;
    }
    
    public void leave(int p) {
        Integer lower = seats.lower(p);
        Integer higher = seats.higher(p);
        int left = lower == null ? -1 : lower;
        int right = higher == null ? n : higher;
        seats.remove(p);
        intervals.remove(new Interval(left, p));
        intervals.remove(new Interval(p, right));
        intervals.add(new Interval(left, right));
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */