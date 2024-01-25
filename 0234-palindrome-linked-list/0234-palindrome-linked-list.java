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
        ListNode duplicate = getDeepCopy(head);
        duplicate = reverse(duplicate);
        ListNode h1 = head, h2 = duplicate;
        while(h1 != null && h2 != null) {
            if(h1.val != h2.val) return false;
            h1 = h1.next;
            h2 = h2.next;
        }
        return true;
    }
    
    public ListNode getDeepCopy(ListNode head) {
        ListNode ans = new ListNode(-1), h1 = head, temp = ans;
        while(h1 != null) {
            temp.next = new ListNode(h1.val);
            temp = temp.next;
            h1 = h1.next;
        }
        return ans.next;
    }
    
    public ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, fwd = null;
        while(curr != null) {
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        return prev;
    }
    
}