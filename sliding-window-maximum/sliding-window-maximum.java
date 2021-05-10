class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<Integer>();
        int n = nums.length, pos = 0;
        int[] res = new int[n - k + 1];
        
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) q.pollLast();
            q.add(i);
            while (!q.isEmpty() && i - q.peekFirst() + 1 > k) q.pollFirst();
            if (i >= k - 1) res[pos++] = nums[q.peekFirst()];
        }
        
        return res;
    }
}