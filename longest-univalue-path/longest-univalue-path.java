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
    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return res == 0 ? res : res - 1;
    }
    
    int res = 0;
    
    private int helper(TreeNode root) {
        if (root == null) 
            return 0;
        int left = helper(root.left), right= helper(root.right);
        int line = 0, sol = 1;
        if (root.left != null && root.left.val == root.val) {
            line = left;
            sol += left;
        }
        if (root.right != null && root.right.val == root.val) {
            line = Math.max(line, right);
            sol += right;
        }
        res = Math.max(res, sol);
        return line + 1;
    }
}