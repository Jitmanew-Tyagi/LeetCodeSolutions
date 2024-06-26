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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        while(head != null && head.val == val) head = head.next;
        ListNode newHead = head, c = head;
        while(c != null && c.next != null) {
            while(c.next != null && c.next.val == val) c.next = c.next.next;
            c = c.next;
        }
        return newHead;      
    }
}