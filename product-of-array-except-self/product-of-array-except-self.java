class Solution {
    public int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        int[] res = new int[l];
        res[0] = 1;
        int cur = nums[0];
        for (int i = 1; i < l; i++) {
            res[i] = cur;
            cur *= nums[i];
        }
        cur = nums[l - 1];
        for (int i = l - 2; i >= 0; i--) {
            res[i] *= cur;
            cur *= nums[i];
        }
        return res;
    }
}