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
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode dummy = new TreeNode(0, root, null);
        TreeNode parent = dummy;
        while (root != null) {
            if (root.val > key) {
                parent = root;
                root = root.left;
            } else if (root.val < key) {
                parent = root;
                root = root.right;
            } else {
                TreeNode child = null;
                if (root.left == null || root.right == null) {
                    child = root.left == null ? root.right : root.left;
                } else {
                    TreeNode cur = root.right;
                    child = root.right;
                    while (cur.left != null)
                        cur = cur.left;
                    cur.left = root.left;
                }
                if (parent.left == root) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
                break;    
            }
        }
        return dummy.left;
    }
}