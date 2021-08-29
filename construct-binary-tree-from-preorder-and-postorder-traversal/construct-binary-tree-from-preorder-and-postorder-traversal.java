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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return helper(preorder, postorder, 0, preorder.length - 1, 0, preorder.length - 1);
    }
    
    private TreeNode helper(int[] pre, int[] post, int prestart, int preend, int poststart, int postend) {
        if (prestart > preend) return null;
        TreeNode root = new TreeNode(pre[prestart]);
        if (prestart == preend) return root;
        
        int i = prestart + 1;
        while (i <= preend && pre[i] != post[postend - 1]) i++;
        root.left = helper(pre, post, prestart + 1, i - 1, poststart, poststart + i - prestart - 2);
        root.right = helper(pre, post, i, preend, poststart + i - prestart - 1, postend - 1);
        return root;
    }
}