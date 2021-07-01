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

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    Map<Integer, Integer> map;
    int count;
    Random rand;
    public Solution(ListNode head) {
        map = new HashMap<Integer, Integer>();
        int idx = 0;
        while (head != null) {
            map.put(idx++, head.val);
            head = head.next;
        }
        count = idx;
        rand = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        return map.get(rand.nextInt(count));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */