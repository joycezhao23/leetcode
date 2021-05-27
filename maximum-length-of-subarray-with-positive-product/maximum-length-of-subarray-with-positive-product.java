class Solution {
    public int getMaxLen(int[] nums) {
        int neg = -1, countNeg = 0, zero = -1, res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                if (neg == -1) neg = i;
                countNeg++;
            }
            
            if (nums[i] == 0) {
                neg = -1; 
                zero = i;
                countNeg = 0;
            } else {
                if (countNeg % 2 == 0) res = Math.max(res, i - zero);
                else res = Math.max(res, i - neg);
            }
        }
        return res;
    }
}