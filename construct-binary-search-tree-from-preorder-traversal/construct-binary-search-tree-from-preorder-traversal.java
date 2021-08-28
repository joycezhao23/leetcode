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
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length - 1);
    }
    
    private TreeNode helper(int[] pre, int start, int end) {
        if (start > end) return null;
        TreeNode root = new TreeNode(pre[start]);
        if (start == end) return root;
        int p = start + 1;
        while (p <= end && pre[p] < pre[start]) p++;
        root.left = helper(pre, start + 1, p - 1);
        root.right = helper(pre, p, end);
        return root;
    }
}