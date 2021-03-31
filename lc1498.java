class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1, res = 0, MOD = (int)Math.pow(10, 9) + 7;
        int[] pow = new int[nums.length];
        pow[0] = 1;
        for (int i = 1; i < nums.length; i++) pow[i] = pow[i - 1] * 2 % MOD;
        while (l <= r) {
            if (nums[l] + nums[r] > target) {
                r--;
            } else {
                res = (res + pow[r - l]) % MOD;
                l++;
            }
        }
        
        return res;
    }
}