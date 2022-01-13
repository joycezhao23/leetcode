class Solution {
    class TreeNode {
        List<TreeNode> subs;
        int time;
        public TreeNode(int time) {
            this.time = time;
            this.subs = new ArrayList<TreeNode>();
        }
    }
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        TreeNode[] nodes = build(n, manager, informTime);
        return helper(nodes[headID]);
    }
    
    private int helper(TreeNode root) {
        if (root == null) return 0;
        int max = 0;
        for (TreeNode next : root.subs) {
            max = Math.max(max, helper(next));
        }
        return max + root.time;
    }
    
    private TreeNode[] build(int n, int[] manager, int[] informTime) {
        TreeNode[] nodes = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new TreeNode(informTime[i]);
        }
        for (int i = 0; i < n; i++) {
            if (manager[i] == -1) continue;
            nodes[manager[i]].subs.add(nodes[i]);
        }
        return nodes;
    }
}