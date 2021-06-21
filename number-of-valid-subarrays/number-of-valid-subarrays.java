class Solution {
    public int validSubarrays(int[] nums) {
        Stack<Integer> st = new Stack<Integer>();
        int n = nums.length, res = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) st.pop();
            res += st.isEmpty() ? n - i : st.peek() - i;
            st.push(i);
        }
        return res;
    }
}