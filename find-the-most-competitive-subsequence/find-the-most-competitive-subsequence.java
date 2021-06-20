class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> st = new Stack<Integer>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && st.peek() > nums[i] && st.size() + n - i - 1 >= k) {
                st.pop();
            }
            if (st.size() < k) st.push(nums[i]);
        }
        int[] res = new int[k];
        while (--k >= 0) res[k] = st.pop();
        return res;
    }
}