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
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }
    
    int max = Integer.MIN_VALUE;
    private int helper(TreeNode root) {
        if (root == null) return 0;
        int val = root.val;
        int left = helper(root.left), right = helper(root.right);
        int val1 = val + left + right, val2 = Math.max(val + left, val + right);
        int sol =  Math.max(val2, val);
        max = Math.max(max, Math.max(val1, sol));
        return sol;
    }
}