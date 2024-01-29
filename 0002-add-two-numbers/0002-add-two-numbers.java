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
        ListNode ans = new ListNode(-1), temp = ans;
        ListNode h1 = l1, h2 = l2;
        
        int carry = 0;
        while(h1 != null && h2 != null) {
            int sum = h1.val + h2.val + carry;
            temp.next = new ListNode(sum % 10);
            carry = sum / 10;
            temp = temp.next;
            h1 = h1.next;
            h2 = h2.next;
        }
        while(h1 != null) {
            int sum = h1.val + carry;
            temp.next = new ListNode(sum % 10);
            carry = sum / 10;
            temp = temp.next;
            h1 = h1.next;
        }
        while(h2 != null) {
            int sum = h2.val + carry;
            temp.next = new ListNode(sum % 10);
            carry = sum / 10;
            temp = temp.next;
            h2 = h2.next;
        }
        if(carry > 0) temp.next = new ListNode(carry);
        return ans.next;
    }
}