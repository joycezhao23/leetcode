# using count of indegree and out degree
class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] list = preorder.split(",");
        int diff = 1;
        for (String s : list) {
            if (--diff < 0) return false;
            if (!s.equals("#")) diff += 2;
        }
        return diff == 0;
    }
}

# using stack
class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] list = preorder.split(",");
        Stack<String> st = new Stack<String>();
        for (String s : list) {
            if (s.equals("#")) {
                while (!st.isEmpty() && st.peek().equals("#")) {
                    st.pop();
                    if (st.isEmpty()) return false;
                    st.pop();
                }
            }
            st.push(s);
        }
        return st.size() == 1 && st.peek().equals("#");
    }
}