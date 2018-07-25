/* To Fix: Gives a stack overflow error on InterviewBit */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public void reverseList(ListNode curr, ListNode prev, ListNode[] head) {
        if (curr.next == null) {
            head[0] = curr;
            curr.next = prev;
            return;
        }
        reverseList(curr.next, curr, head);
        curr.next = prev;
        return;
    }
    public void printList(ListNode a) {
        while (a != null) {
            System.out.print(a.val + "->");
            a = a.next;
        }
        System.out.println();
    }
    public ListNode reorderList(ListNode A) {
        if (A == null || A.next == null || A.next.next == null)
            return A;
        ListNode curr = A;
        ListNode runner = A;
        
        while (runner.next != null && runner.next.next != null) {
            curr = curr.next;
            runner = runner.next.next;
        }
        
        ListNode second = null;
        boolean odd = false;
        if (runner.next == null) {
            second = curr.next;
            curr.next = null;
            odd = true;
        } else {
            second = curr.next.next;
            curr.next.next = null;
        }
        ListNode[] head = new ListNode[1];
        head[0] = second;
        reverseList(second, null, head);
        second = head[0];
        //printList(second);
        curr = A;
        //printList(curr);
        //System.out.println("runner.next" + runner.next.val);
        while (true) {
            if (odd == true) {
                if (curr.next == null) {
                    //System.out.println("break1");
                    break;
                }
            } else {
                if (curr.next.next == null) {
                    //System.out.println("break2");
                    break;
                }
            }
            ListNode temp = curr.next;
            curr.next = second;
            ListNode temp1 = second.next;
            second.next = temp;
            second = temp1;
            if (second == null)
                break;
            curr = temp;
            //System.out.println(curr.val);
            //System.out.println(second.val);
        }
        return A;
    }
}
