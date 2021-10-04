class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1 = cal(s), st2 = cal(t);
        if (st1.size() != st2.size()) return false;
        while (!st1.isEmpty()) {
            if (st1.pop() != st2.pop())
                return false;
        }
        return true;
        
    }
    
    private Stack<Character> cal(String s) {
        Stack<Character> st = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (!st.isEmpty()) st.pop();
            } else {
                st.push(c);
            }
        }
        return st;
    }
}