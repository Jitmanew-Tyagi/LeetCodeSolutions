/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode x= headA, y = headB;
        int noloops = 0;
        while(x != y) {
            x = x.next;
            y = y.next;
            if(x == null) {
                x = headB;
                noloops ++;
                if(noloops > 1) return null;   
            }
            if(y == null) y = headA;
        }
        return x;
    }
}