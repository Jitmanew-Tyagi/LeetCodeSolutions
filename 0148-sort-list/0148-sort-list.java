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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode mid = getMid(head), midNext = mid.next;
        mid.next = null;
        ListNode a = sortList(head);
        ListNode b = sortList(midNext);
        
        return mergeSortedLists(a, b);
    }
    
    public ListNode mergeSortedLists(ListNode a, ListNode b) {
        ListNode ans = new ListNode(-1), temp = ans;
        ListNode h1 = a, h2 = b;
        while(h1 != null && h2 != null) {
            if(h1.val < h2.val) {
                temp.next = new ListNode(h1.val);
                h1 = h1.next;
            } else {
                temp.next = new ListNode(h2.val);
                h2 = h2.next;
            }
            temp = temp.next;
        }
        while(h1 != null) {
            temp.next = new ListNode(h1.val);
            h1 = h1.next;
            temp = temp.next;
        } 
        while(h2 != null) {
            temp.next = new ListNode(h2.val);
            h2 = h2.next;
            temp = temp.next;
        }
        return ans.next;
    }
    
    public ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}