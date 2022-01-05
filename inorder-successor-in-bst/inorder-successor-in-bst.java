/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return helper(root, new Stack<TreeNode>(), p);
    }
    
    private TreeNode helper(TreeNode node, Stack<TreeNode> path, TreeNode target) {
        if (node.val < target.val) {
            path.add(node);
            return helper(node.right, path, target);
        } 
        
        if (node.val > target.val) {
            path.add(node);
            return helper(node.left, path, target);
        } 
        
        if (node.right != null) {
            TreeNode next = node.right;
            while (next.left != null) {
                next = next.left;
            }
            return next;
        } else {
            if (path.isEmpty()) return null;
            TreeNode cur = node;
            while (!path.isEmpty() && path.peek().right == cur) {
                cur = path.pop();
            }
            return path.isEmpty() ? null : path.pop();
        }
    }
}