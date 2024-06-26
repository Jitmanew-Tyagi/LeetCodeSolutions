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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        while(left <= right) {
            ListNode ln = getNode(head, left ++), rn = getNode(head, right --);
            int temp = ln.val;
            ln.val = rn.val;
            rn.val = temp;
        }
        return head;
    }
    
    public ListNode getNode(ListNode head, int idx) {
        ListNode temp = head;
        while(idx --> 1) temp = temp.next;
        return temp;
    }
}