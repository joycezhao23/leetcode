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
    public List<List<String>> printTree(TreeNode root) {
        int h = getHeight(root) - 1;
        int m = h + 1, n = (int)Math.pow(2, h + 1) - 1;
        List<List<String>> res = new ArrayList<List<String>>();
        for (int i = 0; i < m; i++) {
            List<String> row = new ArrayList<String>();
            for (int j = 0; j < n; j++)
                row.add("");
            res.add(row);
        }
        helper(root, 0, (n - 1) / 2, h, res);
        return res;
    }
    
    private void helper(TreeNode node, int row, int col, int h, List<List<String>> res) {
        if (node == null)
            return;
        res.get(row).set(col, String.valueOf(node.val));
        helper(node.left, row + 1, col - (int)Math.pow(2, h - row - 1), h, res);
        helper(node.right, row + 1, col + (int)Math.pow(2, h - row - 1), h, res);
    }
    
    private int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        int left = getHeight(root.left), right = getHeight(root.right);
        return 1 + Math.max(left, right);
    }
}