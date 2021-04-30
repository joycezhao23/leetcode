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
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        
        helper(root, targetSum, 0, map);
        return count;
    }
    
    int count = 0;
    
    private void helper(TreeNode root, int target, int sum, Map<Integer, Integer> map) {
        if (root == null) return;
        
        int cur = sum + root.val;
        count += map.getOrDefault(cur - target, 0);
        int val = map.getOrDefault(cur, 0);
        map.put(cur, val + 1);
        helper(root.left, target, cur, map);
        helper(root.right, target, cur, map);
        map.put(cur, val);
    }
}