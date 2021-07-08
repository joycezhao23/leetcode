class NumArray {
    int[] presum;
    public NumArray(int[] nums) {
        int n = nums.length;
        presum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            presum[i + 1] = presum[i] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return presum[right + 1] - presum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */