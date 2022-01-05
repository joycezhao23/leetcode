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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return root;
        TreeNode leftmost = find(root);
        helper(root);
        return leftmost;
    }
    
    private void helper(TreeNode root) {
        if (root == null || root.left == null && root.right == null) 
            return;
        helper(root.left);
        helper(root.right);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
    }
    
    private TreeNode find(TreeNode root) {
        TreeNode res = root;
        while (res.left != null)
            res = res.left;
        return res;
    }
}