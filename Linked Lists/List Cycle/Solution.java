/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode a) {
        Map<ListNode, Boolean> m = new HashMap<>();
        ListNode curr = a;
        while (curr != null) {
            if (curr.next == null)
                return null;
            if (m.get(curr.next) != null) {
                return curr.next;
            } else {
                m.put(curr, true);
                curr = curr.next;
            }
        }
        return null;
    }
}
