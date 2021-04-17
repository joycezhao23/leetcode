class CustomStack {
    int[] incs;
    int size;
    Stack<Integer> st;

    public CustomStack(int maxSize) {
        size = maxSize;
        incs = new int[maxSize];
        st = new Stack<Integer>();
    }
    
    public void push(int x) {
        if (st.size() < size) {
            st.push(x);
        }
    }
    
    public int pop() {
        if (st.isEmpty()) {
            return -1;
        }
        int pos = st.size() - 1;
        int val = st.pop() + incs[pos];
        if (pos > 0) incs[pos - 1] += incs[pos];
        incs[pos] = 0;
        return val;
    }
    
    public void increment(int k, int val) {
        int pos = Math.min(k, st.size()) - 1;
        if (pos >= 0) incs[pos] += val;
    }
}