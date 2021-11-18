class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == i + 1 || nums[i] == -1) continue;
            int idx = nums[i] - 1;
            while (idx >= 0 && idx != nums[idx] - 1) {
                int next = nums[idx] - 1;
                nums[idx] = idx + 1;
                idx = next;
            }
            if (nums[i] != i + 1) nums[i] = -1;
        }
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == -1)
                res.add(i + 1);
        }
        return res;
    }
}