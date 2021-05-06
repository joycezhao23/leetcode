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
    private ListNode head;
    
    private int getSize(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        int size = getSize(head);
        this.head = head;
        return helper(0, size - 1);
    }
    
    private TreeNode helper(int l, int r) {
        if (l > r) return null;
        
        int mid = l + (r - l) / 2;
        TreeNode left = helper(l, mid - 1);
        TreeNode root = new TreeNode(head.val);
        head = head.next;
        root.left = left;
        root.right = helper(mid + 1, r);
        return root;
    }
}