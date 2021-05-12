class NumArray {
    int[] bit, nums;
    int n;
    public NumArray(int[] nums) {
        n = nums.length;
        bit = new int[n + 1];
        this.nums = new int[n];
        for (int i = 0; i < n; i++) {
            update(i, nums[i]);
        }
    }
    
    public void update(int index, int val) {
        int delta = val - nums[index];
        nums[index] = val;
        for (int i = index + 1; i <= n; i += (i & -i)) {
            bit[i] += delta;
        }
    }
    
    public int sumRange(int left, int right) {
        return sum(right) - sum(left - 1);
    }
    
    private int sum(int index) {
        int res = 0;
        for (int i = index + 1; i > 0; i -= (i & -i)) {
            res += bit[i];
        }
        return res;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */