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
    public ListNode swapPairs(ListNode head) {
        if(head == null) return head;
        ListNode a = head, b = head.next;
        while(a != null && b != null) {
            int temp = a.val;
            a.val = b.val;
            b.val = temp;
            a = a.next.next;
            b = b.next;
            if(b != null) b = b.next;
        }
        return head;
    }
}