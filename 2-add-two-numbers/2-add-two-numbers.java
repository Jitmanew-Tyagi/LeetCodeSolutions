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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1), c1 = l1, c2 = l2, head = ans;
        int carry = 0; 
        while(c1 != null && c2 != null) {
            int sum = c1.val + c2.val + carry;
            carry = sum / 10;
            ans.next = new ListNode(sum % 10);
            ans = ans.next;
            c1 = c1.next; c2 = c2.next;
        } 
        ListNode workable = c1 == null ? c2 : c1;
        while(workable != null) {
            int sum = workable.val + carry;
            carry = sum / 10;
            ans.next = new ListNode(sum % 10);
            ans = ans.next;
            workable = workable.next;
        }
        if(carry > 0) ans.next = new ListNode(carry);
        return head.next;
    }
}