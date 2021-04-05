class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildNode(preorder, inorder, 0, inorder.length - 1);
    }
    
    int pos = 0;
    private TreeNode buildNode(int[] preorder, int[] inorder, int start, int end) {
        int l = preorder.length;
        if (pos >= l || start > end || start < 0 || start >= l || end < 0 || end >= l) return null;
        int val = preorder[pos], i = start;
        
        while (i <= end) {
            if (inorder[i] == val) break;    
            i++;
        }
        
        if (i > end) return null;
        TreeNode node = new TreeNode(val);
        pos++;
        node.left = buildNode(preorder, inorder, start, i - 1);
        node.right = buildNode(preorder, inorder, i + 1, end);
        return node;
    }
}