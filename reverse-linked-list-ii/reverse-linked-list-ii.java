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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevL = dummy;
        while (--left > 0 && --right > 0) prevL = prevL.next;
        ListNode prev = prevL, cur = prevL.next;
        while (right-- > 0) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        prevL.next.next = cur;
        prevL.next = prev;
        return dummy.next;
    }
}