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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0), head = dummy;
        while(l1 != null || l2 != null) {
            int n1 = l1 == null ? 0 : l1.val, n2 = l2 == null ? 0 : l2.val;
            int sum = carry + n1 + n2, val = sum % 10;
            carry = sum / 10;
            head.next = new ListNode(val);
            head = head.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry == 1) head.next = new ListNode(1);
        return dummy.next;
    }
}