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
    
    private int[] helper(TreeNode root) {
        if (root == null)
            return new int[2];
        int[] left = helper(root.left), right = helper(root.right);
        int increase = 1, decrease = 1, connect = 1;
        if (root.left != null) {
            if (root.left.val == root.val - 1)
                increase += left[0];
            if (root.left.val == root.val + 1)
                decrease += left[1];
        }
        if (root.right != null) {
            if (root.right.val == root.val - 1) {
                connect = decrease + right[0];
                increase = Math.max(increase, right[0] + 1);
            } else if (root.right.val == root.val + 1) {
                connect = increase + right[1];
                decrease = Math.max(decrease, right[1] + 1);
            }
        }
        max = Math.max(max, Math.max(connect, Math.max(increase, decrease)));
        return new int[]{increase, decrease};
    }
}