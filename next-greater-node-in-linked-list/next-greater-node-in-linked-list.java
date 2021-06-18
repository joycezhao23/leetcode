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
    public int[] nextLargerNodes(ListNode head) {
        int[] res = new int[getSize(head)];
        Stack<int[]> st = new Stack<int[]>();
        int count = 0;
        while (head != null) {
            while (!st.isEmpty() && head.val > st.peek()[1]) {
                res[st.pop()[0]] = head.val;
            }
            st.push(new int[]{count++, head.val});
            head = head.next;
        }
        return res;
    }
    
    private int getSize(ListNode head) {
        ListNode cur = head;
        int n = 0;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        return n;
    }
}