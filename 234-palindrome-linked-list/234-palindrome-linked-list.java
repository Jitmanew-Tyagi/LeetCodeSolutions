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
    public boolean isPalindrome(ListNode head) {
        ListNode mid = getMid(head);
        ListNode sh = mid.next;
        mid.next = null;
        sh = reverseList(sh);
        while(head != null && sh != null) {
            if(head.val != sh.val) return false;
            head = head.next;
            sh = sh.next;
        }
        return true;
    }
    
    public ListNode reverseList(ListNode head) {
        ListNode ansHead = new ListNode(-1, null), temp1 = head;
        while(temp1 != null) {
            ListNode tba = new ListNode(temp1.val, ansHead.next);
            ansHead.next = tba;
            temp1 = temp1.next;
        }
        return ansHead.next;
    }
    
    public ListNode getMid(ListNode head) {
        ListNode s = head, f = head;
        while(f.next != null && f.next.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }
}