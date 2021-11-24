class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int median = findKthLargest(nums, 0, n - 1, (n + 1) / 2);
        int left = 0, i = 0, right = n - 1;
        while (i <= right) {
            if (nums[newIndex(i,n)] > median) {
                swap(nums, newIndex(left++,n), newIndex(i++,n));
            }
            else if (nums[newIndex(i,n)] < median) {
                swap(nums, newIndex(right--,n), newIndex(i,n));
            }
            else {
                i++;
            }
        }
    }
    
    private int newIndex(int index, int n) {
        return (1 + 2*index) % (n | 1);
    }
    
    private int findKthLargest(int[] nums, int left, int right, int k) {
        int l = left, r = right, pivot = nums[left + (right - left) / 2], idx = left;
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
            return findKthLargest(nums, r + 1, right, k);
        } else if (right - l + 1 >= k) {
            return pivot;
        } else {
            return findKthLargest(nums, left, l - 1, k - (right - l + 1));
        }
    }
    
    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}