class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }
    
    private int quickSelect(int[] nums, int left, int right, int k) {
        int l = left, r = right, idx = l;
        int pivot = nums[l + (r - l) / 2];
        
        while (idx <= r) {
            if (nums[idx] < pivot) {
                swap(nums, l, idx);
                l++;
                idx++;
            } else if (nums[idx] > pivot) {
                swap(nums, idx, r);
                r--;
            } else {
                idx++;
            }
        }
        
        if (right - r >= k) {
            return quickSelect(nums, r + 1, right, k);
        } else if (right - l + 1 >= k) {
            return pivot;
        } else {
            return quickSelect(nums, left, l - 1, k - (right - l + 1));    
        }
    }
    
    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}