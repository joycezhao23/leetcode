class MinStack {
    List<Integer> st, minSt;
    
    public MinStack() {
        st = new ArrayList<Integer>();
        minSt = new ArrayList<Integer>();
    }
    
    public void push(int val) {
        st.add(val);
        if (minSt.isEmpty()) {
            minSt.add(val);
        } else {
            minSt.add(Math.min(minSt.get(minSt.size() - 1), val));
        }
    }
    
    public void pop() {
        int last = st.size() - 1;
        st.remove(last);
        minSt.remove(last);
    }
    
    public int top() {
        return st.get(st.size() - 1);
    }
    
    public int getMin() {
        return minSt.get(st.size() - 1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */