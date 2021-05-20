class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<Integer>();
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(cur);
                cur = 0;
            } else {
                cur = st.pop() + Math.max(1, 2 * cur);
            }
        }
        return cur;
    }
}