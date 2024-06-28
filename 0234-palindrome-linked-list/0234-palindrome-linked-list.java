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
        System.out.println(mid.val);
        ListNode nh = mid.next;
        mid.next = null;
        nh = reverse(nh);
        while(nh != null) {
            if(head.val != nh.val) return false;
            head = head.next;
            nh = nh.next;
        }
        return true;
    }
    
    public ListNode getMid(ListNode head) {
        ListNode s = head, f = head;
        while( f.next != null && f.next.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }
    
    public ListNode reverse(ListNode head) {
        ListNode p = null, c = head, n = head;
        while(c != null) {
            n = c.next;
            c.next = p;
            p = c;
            c = n;
        }
        return p;
    }
}