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
    public ListNode doubleIt(ListNode head) {
        head = reverse(head);
        ListNode curr = head;
        int carry = 0;
        ListNode tail = null;
        while(curr != null) {
            int num = curr.val * 2 + carry;
            curr.val = num % 10;
            carry = num / 10;
            if(curr.next == null) tail = curr;
            curr = curr.next;
        }
        if(carry != 0) tail.next = new ListNode(carry);
        return reverse(head);
    }
    
    public ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, next = head;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr; 
            curr = next;
        }
        return prev;
    }
    
}