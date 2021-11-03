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
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return res;
    }
    int res;
    private void helper(TreeNode root, int cur) {
        int val = cur * 10 + root.val;
        if (root.left == null && root.right == null) {
            res += val;
            return;
        }
        if (root.left != null)
            helper(root.left, val);
        if (root.right != null)
            helper(root.right, val);
    }
}