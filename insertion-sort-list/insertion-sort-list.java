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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = head.next;
        while (head != null) {
            ListNode prev = dummy, cur = dummy.next, next = head.next;
            while (cur != head && cur.val < head.val) {
                prev = prev.next;
                cur = cur.next;
            }
            if (cur != head) {
                prev.next = head;
                head.next = cur;
                while(cur.next != head) cur = cur.next;
                cur.next = next;
            }
            head = next;
        }
        return dummy.next;
    }
}