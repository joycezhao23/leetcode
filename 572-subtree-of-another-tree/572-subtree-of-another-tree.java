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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (helper(root, subRoot))
            return true;
        if (root == null || subRoot == null)
            return false;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    private boolean helper(TreeNode root, TreeNode sr) {
        if (root == null && sr == null)
            return true;
        if (root == null || sr == null || root.val != sr.val)
            return false;
        return helper(root.left, sr.left) && helper(root.right, sr.right);
    }
}