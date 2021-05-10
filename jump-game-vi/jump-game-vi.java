class Solution {
    public int maxResult(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int max = q.isEmpty() ? 0 : nums[q.peekFirst()];
            nums[i] += max;
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) q.pollLast();
            q.add(i);
            while (!q.isEmpty() && i - q.peekFirst() + 1 > k) q.pollFirst();
        }
        return nums[nums.length - 1];
    }
}