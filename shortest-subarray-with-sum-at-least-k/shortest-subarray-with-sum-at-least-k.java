class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length, res = n + 1;
        int[] psum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            psum[i + 1] = psum[i] + nums[i];
        }
        Deque<Integer> dq = new LinkedList<Integer>();
        for (int i = 0; i <= n; i++) {
            while (!dq.isEmpty() && psum[i] - psum[dq.getFirst()] >= k) {
                res = Math.min(res, i - dq.pollFirst());
            }
            while (!dq.isEmpty() && psum[i] <= psum[dq.getLast()]) {
                dq.pollLast();
            }
            dq.addLast(i);
        }
        return res == n + 1 ? -1 : res;
    }
}