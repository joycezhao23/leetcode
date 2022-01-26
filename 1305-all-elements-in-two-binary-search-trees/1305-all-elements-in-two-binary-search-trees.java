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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<Integer>(), l2 = new ArrayList<Integer>();
        getElements(root1, l1);
        getElements(root2, l2);
        List<Integer> res = new ArrayList<Integer>();
        
        int idx1 = 0, idx2 = 0;
        while (idx1 < l1.size() && idx2 < l2.size()) {
            if (l1.get(idx1) < l2.get(idx2)) {
                res.add(l1.get(idx1++));
            } else {
                res.add(l2.get(idx2++));
            }
        }
        
        while (idx1 < l1.size()) res.add(l1.get(idx1++));
        while (idx2 < l2.size()) res.add(l2.get(idx2++));
        return res;
    }
    
    private void getElements(TreeNode root, List<Integer> res) {
        if (root == null) return;
        getElements(root.left, res);
        res.add(root.val);
        getElements(root.right, res);
    }
}