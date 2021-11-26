class Solution {
    class TreeNode {
        int val, count;
        List<TreeNode> children;
        public TreeNode(int val) {
            this.val = val;
            this.count = 0;
            this.children = new ArrayList<TreeNode>();
        }
    }
    
    public int countHighestScoreNodes(int[] parents) {
        n = parents.length;
        TreeNode root = buildTree(parents);
        helper(root);
        return total;
    }
    
    long max = 0;
    int total = 0;
    int n;
    
    private int helper(TreeNode root) {
        if (root == null)
            return 0;
        int count = 1;
        long mul = 1;
        for (TreeNode child : root.children) {
            int value = helper(child);
            count += value;
            mul *= Math.max(1, value);
        }
        mul *= Math.max(1, n - count);
        if (mul > max) {
            max = mul;
            total = 1;
        } else if (mul == max) {
            total += 1;
        }
        return count;
    }
    
    private TreeNode buildTree(int[] parents) {
        TreeNode[] map = new TreeNode[n];
        for (int i = 0; i < n; i++) 
            map[i] = new TreeNode(i);
        for (int i = 1; i < n; i++) 
            map[parents[i]].children.add(map[i]);
        return map[0];
    }
}