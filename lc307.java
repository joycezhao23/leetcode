class NumArray {
    class SegmentNode {
        int start, end, sum;
        SegmentNode left, right;
        
        public SegmentNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    public SegmentNode buildTree(int[] nums, int start, int end) {
        if (start > end) return null;
        SegmentNode root = new SegmentNode(start, end);
        if (start == end) {
            root.sum = nums[start];
            return root;
        }
        
        int mid = start + (end - start) / 2;
        root.left = buildTree(nums, start, mid);
        root.right = buildTree(nums, mid + 1, end);
        root.sum = root.left.sum + root.right.sum;
        return root;
    }
    
    public void updateNode(SegmentNode node, int index, int val) {
        if (node.start == node.end) {
            node.sum = val;
            return;
        }
        
        int mid = node.start + (node.end - node.start) / 2;
        if (mid < index) {
            updateNode(node.right, index, val);
        } else {
            updateNode(node.left, index, val);
        }
        node.sum = node.left.sum + node.right.sum;
    }
       
    public int getSum(SegmentNode node, int left, int right) {
        if (left == node.start && right == node.end) return node.sum;
        int mid = node.start + (node.end - node.start) / 2;
        if (mid < left) return getSum(node.right, left, right);
        if (mid >= right) return getSum(node.left, left, right);
        return getSum(node.left, left, mid) + getSum(node.right, mid + 1, right);
    }

    SegmentNode root;
    
    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }
    
    public void update(int index, int val) {
        updateNode(root, index, val);
    }
    
    public int sumRange(int left, int right) {
        return getSum(root, left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */