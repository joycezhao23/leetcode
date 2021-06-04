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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0), head = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);
        for (ListNode n : lists) {
            if (n != null) pq.add(n);
        }
        
        while (!pq.isEmpty()) {
            ListNode cur = pq.poll();
            head.next = cur;
            head = head.next;
            if (cur.next != null) pq.add(cur.next);
        }
        
        return dummy.next;
    }
}