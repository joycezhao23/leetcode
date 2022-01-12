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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        helper(dummy, root, target);
        return dummy.left;
    }
    
    private void helper(TreeNode parent, TreeNode node, int target) {
        if (node == null)
            return;
        helper(node, node.left, target);
        helper(node, node.right, target);
        if (node.left == null && node.right == null) {
            if (target == node.val) {
                if (parent.left == node) parent.left = null;
                else parent.right = null;
            }
        }
    }
}