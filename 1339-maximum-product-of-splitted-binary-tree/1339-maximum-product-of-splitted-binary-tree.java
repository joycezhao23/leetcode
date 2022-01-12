/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxProduct(TreeNode root) {
        long total = getTotal(root);
        helper(root, total);
        return (int)(max % 1000000007);
    }
    
    long max = 0;
    
    private long helper(TreeNode root, long total) {
        if (root == null) return 0;
        long sum = root.val + helper(root.left, total) + helper(root.right, total);
        max = Math.max(max, sum * (total - sum));
        return sum;
    }
    
    private long getTotal(TreeNode root) {
        if (root == null) return 0;
        return root.val + getTotal(root.left) + getTotal(root.right);
    }
}