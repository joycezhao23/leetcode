class Solution {
    List<Integer> list = new ArrayList<Integer>();
    int i = 0;
    
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        return dfs(root, voyage) ? list : Arrays.asList(-1);
    }
    
    private boolean dfs(TreeNode root, int[] v) {
        if (root == null) return true;
        if (root.val != v[i++]) return false;
        if (root.left != null && root.left.val != v[i]) {
            list.add(root.val);
            return dfs(root.right, v) && dfs(root.left, v);
        }
        return dfs(root.left, v) && dfs(root.right, v);
    }
}