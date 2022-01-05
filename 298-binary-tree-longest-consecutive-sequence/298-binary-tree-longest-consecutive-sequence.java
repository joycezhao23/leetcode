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
    public int longestConsecutive(TreeNode root) {
        helper(root);
        return max;
    }
    int max = 0;
    
    private int helper(TreeNode root) {
        if (root == null)
            return 0;
        int res = 1;
        int left = helper(root.left), right = helper(root.right);
        if (root.left != null && root.left.val == root.val + 1) {
            res = Math.max(res, 1 + left);
        }
        if (root.right != null && root.right.val == root.val + 1) {
            res = Math.max(res, 1 + right);
        }
        max = Math.max(res, max);
        return res;
    }
}