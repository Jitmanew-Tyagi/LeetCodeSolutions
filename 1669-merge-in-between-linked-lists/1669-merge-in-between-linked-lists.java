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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode aNode = getNode(list1, a - 1);
        ListNode bNode = getNode(list1, b + 1);
        aNode.next = list2;
        getTail(list2).next = bNode;
        return list1;
    }
    
    public ListNode getTail(ListNode head) {
        while(head.next != null) head = head.next;
        return head;
    }
    
    public ListNode getNode(ListNode head, int idx) {
        while(idx --> 0) head = head.next;
        return head;
    }
}