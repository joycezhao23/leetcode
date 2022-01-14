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
    public int maxSumBST(TreeNode root) {
        helper(root);
        return max;
    }
    
    int max = 0;
    
    private int[] helper(TreeNode root) {
        if (root == null)
            return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        int[] left = helper(root.left), right = helper(root.right);
        if (left[0] != 1 || right[0] != 1)
            return new int[]{0, 0,0,0};
        int[] res = new int[4];
        if (left[2] < root.val && right[1] > root.val) {
            res[0] = 1;
            res[1] = Math.min(root.val, left[1]);
            res[2] = Math.max(root.val, right[2]);
            res[3] = left[3] + right[3] + root.val;
            max = Math.max(max, res[3]);
        }
        return res;
    }
}