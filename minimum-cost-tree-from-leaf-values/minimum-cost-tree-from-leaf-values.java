class Solution {
    public int mctFromLeafValues(int[] arr) {
        int res = 0;
        Stack<Integer> st = new Stack<Integer>();
        st.push(Integer.MAX_VALUE);
        for (int num : arr) {
            while (st.peek() <= num) {
                int mid = st.pop();
                res += mid * Math.min(st.peek(), num);
            }
            st.push(num);
        }
        
        while (st.size() > 2) {
            res += st.pop() * st.peek();
        }
        return res;
    } 
}