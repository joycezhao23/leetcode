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
    public int longestZigZag(TreeNode root) {
        helper(root);
        return max - 1;
    }
    
    int max = 0;
    
    private int[] helper(TreeNode root) {
        if (root == null)
            return new int[2];
        int left = 1 + helper(root.left)[1], right = 1 + helper(root.right)[0];
        max = Math.max(max, Math.max(left, right));
        return new int[]{left, right};
    }
}