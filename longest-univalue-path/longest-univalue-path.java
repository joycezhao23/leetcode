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
    int res = 0;
    
    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return res == 0 ? 0 : res - 1;
    }
    
    private int helper(TreeNode root) {
        if (root == null) return 0;
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        int count = 1, longer = 0;
        if (root.left != null && root.left.val == root.val) {
            count += left;
            longer = left;
        }
        if (root.right != null && root.right.val == root.val) {
            count += right;
            longer = Math.max(longer, right);
        }
        res = Math.max(res, count);
        return 1 + longer;
    }
    
    
}