class Solution {
    int l;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        l = inorder.length;
        return buildNode(inorder, postorder, 0, l - 1, l - 1);
    }
    
    private TreeNode buildNode(int[] inorder, int[] postorder, int istart, int iend, int pindex) {
        if (pindex < 0 || istart > iend) return null;
        int idx = istart, val = postorder[pindex];
        while (idx <= iend) {
            if (inorder[idx] == val) break;
            idx++;
        }
        
        if (idx > iend) return null;
        TreeNode node = new TreeNode(val);
        node.right = buildNode(inorder, postorder, idx + 1, iend, pindex - 1);
        node.left = buildNode(inorder, postorder, istart, idx - 1, pindex - (iend - idx + 1));
        return node;
    }
}