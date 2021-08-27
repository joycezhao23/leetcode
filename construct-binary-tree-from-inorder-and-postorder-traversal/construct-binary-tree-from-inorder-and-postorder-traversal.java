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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
    }
    
    private TreeNode helper(int[] in, int[] post, int istart, int iend, int pidx) {
        if (istart > iend) return null;
        if (istart == iend) return new TreeNode(in[istart]);
        TreeNode root = new TreeNode(post[pidx]);
        int idx = istart;
        while (idx <= iend && in[idx] != post[pidx]) idx++;
        root.right = helper(in, post, idx + 1, iend, pidx - 1);
        root.left = helper(in, post, istart, idx - 1, pidx - (iend - idx) - 1);
        return root;
    }
}