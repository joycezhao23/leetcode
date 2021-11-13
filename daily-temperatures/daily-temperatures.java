class Solution {
    public int[] dailyTemperatures(int[] t) {
        Stack<Integer> q = new Stack<Integer>();
        int n = t.length;
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!q.isEmpty() && t[i] >= t[q.peek()])
                q.pop();
            if (!q.isEmpty())
                res[i] = q.peek() - i;
            q.add(i);
        }
        return res;
    }
}