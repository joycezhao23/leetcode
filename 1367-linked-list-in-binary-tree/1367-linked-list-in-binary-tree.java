/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        return dfs(root, head, head);
    }
    
    public boolean dfs(TreeNode root, ListNode head, ListNode h) {
        if(head == null) return true;
        if(root == null) return false;
        return match(root, head) || dfs(root.left, h, h) || dfs(root.right, h, h);
    }
    
    public boolean match(TreeNode root, ListNode head) {
        if(head == null) return true;
        if(root == null) return false;
        return (root.val == head.val) 
                && (match(root.left, head.next) || match(root.right, head.next));
    }

}