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
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) return 0;
        helper(root, 0);
        return total;
    }
    
    int total = 0;
    
    private void helper(TreeNode root, int prev) {
        int val = (prev << 1) + root.val;
        if (root.left == null && root.right == null) {
            total += val;
            return;
        }
        if (root.left != null)
            helper(root.left, val);
        if (root.right != null)
            helper(root.right, val);        
    }
}