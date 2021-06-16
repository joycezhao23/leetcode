class Solution {
    public int maxWidthRamp(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int pos = getPos(nums, list, nums[i]);
            if (pos != -1) res = Math.max(res, i - pos);
            else list.add(i);
        }
        return res;
    }
    
    private int getPos(int[] nums, List<Integer> list, int target) {
        int n = list.size();
        if (n == 0 || target < nums[list.get(n - 1)]) return -1;
        int l = 0, r = n - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[list.get(mid)] <= target) {
                r = mid;
            } else {
                l = mid;
            }
        }
        if (nums[list.get(l)] <= target) return list.get(l);
        return list.get(r);
    }
}