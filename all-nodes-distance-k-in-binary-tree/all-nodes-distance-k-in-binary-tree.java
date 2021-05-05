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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        find(root, target, map);
        List<Integer> res = new ArrayList<Integer>();
        helper(root, target, K, map.get(root.val), map, res);
        return res;
    }
    
    private void helper(TreeNode root, TreeNode target, int k, int dist, Map<Integer, Integer> map, List<Integer> res) {
        if (root == null) return;
        int val = root.val;
        if (map.containsKey(val)) dist = map.get(val);
        if (dist == k) res.add(val);
        helper(root.left, target, k, dist + 1, map, res);
        helper(root.right, target, k, dist + 1, map, res);
    }
    
    private int find(TreeNode root, TreeNode target, Map<Integer, Integer> map) {
        if (root == null) return -1;
        if (root == target) {
            map.put(root.val, 0);
            return 0;
        }
        
        int left = find(root.left, target, map);
        if (left >= 0) {
            map.put(root.val, left + 1);
            return left + 1;
        }
        
        int right = find(root.right, target, map);
        if (right >= 0) {
            map.put(root.val, right + 1);
            return right + 1;
        }
        
        return -1;
    }
}