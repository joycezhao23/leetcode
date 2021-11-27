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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, TreeNode> map = new HashMap<String, TreeNode>();
        List<TreeNode> res = new ArrayList<TreeNode>();
        Set<TreeNode> sres = new HashSet<TreeNode>();
        helper(root, map, sres);
        for (TreeNode r : sres)
            res.add(r);
        return res;
    }
    
    private String helper(TreeNode root, Map<String, TreeNode> map, Set<TreeNode> res) {
        if (root == null) return "";
        String left = helper(root.left, map, res), right = helper(root.right, map, res);
        String val = "l" + left + "root" + String.valueOf(root.val) + "r" + right;
        if (map.containsKey(val)) {
            res.add(map.get(val));
        } else {
            map.put(val, root);
        }
        return val;
    }
}