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
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res);
        return res;
    }
    
    private void helper(TreeNode root, List<Integer> res) {
        if (root.left == null && root.right == null) 
            return;
        if (root.left != null && root.right != null) {
            helper(root.right, res);
            helper(root.left, res);
        }
        if (root.left == null) {
            res.add(root.right.val);
            helper(root.right, res);
        }
        if (root.right == null) {
            res.add(root.left.val);
            helper(root.left, res);
        }
    }
}