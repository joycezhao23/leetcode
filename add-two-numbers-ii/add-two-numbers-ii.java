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
        ListNode rl1 = reverse(l1), rl2 = reverse(l2);
        ListNode dummy = new ListNode(0), head = dummy;
        int carry = 0;
        while (rl1 != null || rl2 != null) {
            int sum = carry;
            if (rl1 != null) {
                sum += rl1.val;
                rl1 = rl1.next;
            }
            if (rl2 != null) {
                sum += rl2.val;
                rl2 = rl2.next;
            }
            head.next = new ListNode(sum % 10);
            head = head.next;
            carry = sum / 10;
        }
        if (carry == 1) head.next = new ListNode(1);
        return reverse(dummy.next);
    }
    
    private ListNode reverse(ListNode l) {
        ListNode cur = l, prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}