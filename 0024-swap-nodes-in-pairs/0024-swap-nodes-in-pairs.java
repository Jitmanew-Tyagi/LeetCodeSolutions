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
        if(head == null) return null;
        ListNode s = head, f = head.next;
        while(f != null) {
            int temp = s.val;
            s.val = f.val;
            f.val = temp;
            s = f.next;
            f = s == null ? s : s.next;
        }
        return head;
    }
}