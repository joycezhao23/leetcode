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
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return res - 1;
    }
    int res = 0;
    
    private int helper(TreeNode root) {
        if (root == null) 
            return 0;
        int l = helper(root.left), r = helper(root.right);
        res = Math.max(res, 1 + l + r);
        return Math.max(l, r) + 1;
    }
}