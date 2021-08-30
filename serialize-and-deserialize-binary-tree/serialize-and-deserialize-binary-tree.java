/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur == null) {
                sb.append("#,");
            } else {
                sb.append(cur.val).append(",");
                q.add(cur.left);
                q.add(cur.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        String[] sdata = data.split(",");
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        TreeNode root = getNode(sdata[0]);
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < sdata.length) {
            TreeNode cur = q.poll();
            if (cur == null)
                continue;
            TreeNode left = getNode(sdata[i++]);
            TreeNode right = getNode(sdata[i++]);
            cur.left = left;
            cur.right = right;
            q.add(left);
            q.add(right);
        }
        return root;
    }
    
    private TreeNode getNode(String s) {
        if (s.equals("#"))
            return null;
        return new TreeNode(Integer.parseInt(s));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));