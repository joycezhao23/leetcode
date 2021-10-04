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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(root, res);
        return res;
    }
    
    private int helper(TreeNode root, List<List<Integer>> res) {
        if (root == null) return -1;
        int l = helper(root.left, res);
        int r = helper(root.right, res);
        int level = Math.max(l, r) + 1;
        if (res.size() <= level) res.add(new ArrayList<Integer>());
        res.get(level).add(root.val);
        return level;
    }
}