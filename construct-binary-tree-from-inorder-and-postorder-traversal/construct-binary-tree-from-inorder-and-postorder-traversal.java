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
    
    private TreeNode helper(int[] inorder, int[] postorder, int istart, int iend, int pidx) {
        if (istart > iend) return null;
        if (istart == iend) return new TreeNode(inorder[istart]);
        TreeNode root = new TreeNode(postorder[pidx]);
        int i = istart;
        while (i <= iend && inorder[i] != postorder[pidx]) i++;
        root.left = helper(inorder, postorder, istart, i - 1, pidx - (iend - i) - 1);
        root.right = helper(inorder, postorder, i + 1, iend, pidx - 1);
        return root;
    }
}