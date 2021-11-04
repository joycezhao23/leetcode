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
    public int sumOfLeftLeaves(TreeNode root) {
        helper(root, false);
        return res;
    }
    int res = 0;
    
    private void helper(TreeNode root, boolean left) {
        if (root == null) 
            return;
        if (root.left == null && root.right == null) {
            if (left) 
                res += root.val;
            return;
        }
        helper(root.left, true);
        helper(root.right, false);
    }
}