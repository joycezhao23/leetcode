class Solution {
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length, MOD = (int)1e9+7;
        int[] leftBound = new int[n], rightBound = new int[n];
        long[] presum = new long[n + 1];
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < n; i++) presum[i + 1] = nums[i] + presum[i];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) st.pop();
            if (st.isEmpty()) {
                leftBound[i] = 0;
            } else {
                leftBound[i] = st.peek() + 1;
            }
            st.push(i);
        }
        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) st.pop();
            if (st.isEmpty()) {
                rightBound[i] = n - 1;
            } else {
                rightBound[i] = st.peek() - 1;
            }
            st.push(i);
        }
        long max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, (presum[rightBound[i] + 1] - presum[leftBound[i]]) * nums[i]);
        }
        return (int)(max % MOD);
    }
}