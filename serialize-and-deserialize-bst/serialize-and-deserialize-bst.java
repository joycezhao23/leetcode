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
        serializeTree(root, sb);
        return sb.toString();
    }
    
    private void serializeTree(TreeNode root, StringBuilder sb) {
        if (root == null) 
            return;
        sb.append(root.val);
        sb.append(",");
        serializeTree(root.left, sb);
        serializeTree(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0)
            return null;
        String[] sarr = data.split(",");
        Queue<Integer> q = new LinkedList<Integer>();
        for (String s : sarr) 
            q.add(Integer.parseInt(s));
        return deserialize(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode deserialize(Queue<Integer> q, int min, int max) {
        if (q.isEmpty()) 
            return null;
        int val = q.peek();
        if (val > max || val < min)
            return null;
        TreeNode root = new TreeNode(q.poll());
        root.left = deserialize(q, min, val);
        root.right = deserialize(q, val, max);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;