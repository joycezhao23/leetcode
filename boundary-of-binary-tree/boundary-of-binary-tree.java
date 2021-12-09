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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(root.val);
        if (root.left != null) {
            leftBoundry(root.left, res);
            res.remove(res.size() - 1);
        }
        if (root.left != null || root.right != null)
            getLeaves(root, res);
        if (root.right != null) {
            List<Integer> rb = new ArrayList<Integer>();
            rightBoundry(root.right, rb);
            rb.remove(rb.size() - 1);
            Collections.reverse(rb);
            res.addAll(rb);
        }
        return res;        
    }
    
    private void rightBoundry(TreeNode node, List<Integer> res) {
        res.add(node.val);
        if (node.right != null) {
            rightBoundry(node.right, res);
        } else if (node.left != null) {
            rightBoundry(node.left, res);
        }
    }
    
    private void getLeaves(TreeNode root, List<Integer> res) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            res.add(root.val);
            return;
        }
        getLeaves(root.left, res);
        getLeaves(root.right, res);        
    }
    
    private void leftBoundry(TreeNode node, List<Integer> res) {
        res.add(node.val);
        if (node.left != null) {
            leftBoundry(node.left, res);
        } else if (node.right != null) {
            leftBoundry(node.right, res);
        }
    }
}