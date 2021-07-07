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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0), tail = dummy;
        int size = getSize(head), groups = size / k, c = 0;
        while (head != null && c++ < groups) {
            int count = 0;
            ListNode prev = null;
            while (head != null && count++ < k) {
                ListNode next = head.next;
                head.next = prev;
                prev = head;
                head = next;
            }
            tail.next = prev;
            while (tail.next != null) tail = tail.next;
        }
        tail.next = head;
        return dummy.next;
    }
    
    private int getSize(ListNode head) {
        ListNode cur = head;
        int c = 0;
        while (cur != null) {
            c++;
            cur = cur.next;
        }
        return c;
    }
}