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
        ListNode copy = getDeepCopy(head);
        copy = reverseList(copy);
        return compareLists(head, copy);
    }
    
    public ListNode getDeepCopy(ListNode head) {
        ListNode ans = new ListNode(-1), temp = ans;
        while(head != null) {
            temp.next = new ListNode(head.val);
            head = head.next;
            temp = temp.next;
        }
        return ans.next;
    }
    
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode fwd = current.next;
            current.next = prev;
            prev = current;
            current = fwd;
        }
        return prev; // The new head of the reversed list
    }
    
    public boolean compareLists(ListNode list1, ListNode list2) {
        while (list2 != null) {
            if (list1.val != list2.val) {
                return false;
            }
            list1 = list1.next;
            list2 = list2.next;
        }
        return true;
    }
}