class Solution {
    class Result {
        int min, max, count;
        public Result(int count, int min, int max) {
            this.min = min;
            this.max = max;
            this.count = count;
        }
    }
    
    public int largestBSTSubtree(TreeNode root) {
        helper(root);
        return maxCount;
    }
    
    int maxCount = 0;
    
    private Result helper(TreeNode root) {
        if (root == null) return null;
        
        Result left = helper(root.left);
        Result right = helper(root.right);
        int count = 1, min = root.val, max = root.val;
        
        if (left != null) {
            if (left.count == -1 || left.max >= root.val) return new Result(-1, min, max);
            min = left.min;
            count += left.count;
        }
        
        if (right != null) {
            if (right.count == -1 || right.min <= root.val) return new Result(-1, min, max);
            max = right.max;
            count += right.count;
        }
        
        maxCount = Math.max(maxCount, count);
        
        return new Result(count, min, max);
    }
}