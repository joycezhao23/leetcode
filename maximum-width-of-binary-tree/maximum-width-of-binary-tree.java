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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        q.add(root);
        map.put(root, 1);
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            int start = -1, end = -1;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (i == 0) start = map.get(node);
                if (i == size - 1) end = map.get(node);
                if (node.left != null) {
                    q.add(node.left);
                    map.put(node.left, map.get(node) * 2);
                }                    
                if (node.right != null) {
                    q.add(node.right);
                    map.put(node.right, map.get(node) * 2 + 1);
                }                    
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }
}