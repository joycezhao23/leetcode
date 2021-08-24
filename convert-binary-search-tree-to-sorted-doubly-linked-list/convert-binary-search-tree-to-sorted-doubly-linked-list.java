/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    Node head = null, prev = null;
    public Node treeToDoublyList(Node root) {
        helper(root);
        if (head != null) {
            head.left = prev;
            prev.right = head;    
        }
        return head;
    }
    
    private void helper(Node root) {
        if (root == null) return;
        helper(root.left);
        if (prev != null) {
            prev.right = root;
            root.left = prev;
        }
        prev = root;
        if (head == null) head = root;
        helper(root.right);
    }
}