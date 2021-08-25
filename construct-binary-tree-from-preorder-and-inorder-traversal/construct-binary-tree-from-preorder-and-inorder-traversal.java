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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, inorder.length - 1, 0);
    }
    
    private TreeNode helper(int[] pre, int[] in, int istart, int iend, int pidx) {
        if (istart > iend) return null;
        if (istart == iend) return new TreeNode(in[istart]);
        TreeNode node = new TreeNode(pre[pidx]);
        int i = istart;
        while (i <= iend && in[i] != pre[pidx]) i++;
        node.left = helper(pre, in, istart, i - 1, pidx + 1);
        node.right = helper(pre, in, i + 1, iend, pidx + i - istart + 1);
        return node;
    }
}