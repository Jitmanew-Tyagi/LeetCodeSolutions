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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode x = head, slow = head, fast = head;
        for(int i = 0; i < k - 1; i ++) fast = fast.next;
        x = fast;
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        int data = x.val;
        x.val = slow.val;
        slow.val = data;
        return head;
    }
}