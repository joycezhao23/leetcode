class Solution {
    public int countNodes(TreeNode root) {
        int h = height(root);
        if (h == -1) return 0;
        if (height(root.right) == h - 1) {
            return (1 << h) + countNodes(root.right);
        } else {
            return (1 << h - 1) + countNodes(root.left);
        }
    }
    
    private int height(TreeNode root) {
        int h = -1;
        while (root != null) {
            root = root.left;
            h++;
        }
        return h;
    }
}