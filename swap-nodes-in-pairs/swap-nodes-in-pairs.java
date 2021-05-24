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
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode dummy = new ListNode(0), prev = dummy;
        ListNode n1 = head;
        while (n1 != null && n1.next != null) {
            ListNode next = n1.next.next;
            prev.next = n1.next;
            n1.next.next = n1;
            n1.next = next;
            prev = n1;
            n1 = n1.next;
        }
        return dummy.next;
    }
}