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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head, ans = new ListNode(-1);
        int size = getSize(head);
        if(size < k) return head;
        while(size >= k) {
            ListNode curr = null;
            for(int i = 0; i < k; i ++) {
                ListNode rn = temp;
                temp = temp.next;
                rn.next = null;
                size --;
                curr = addFirst(curr, rn);
            }
            tail(ans).next = curr;
        }
        tail(ans).next = temp;
        return ans.next;
    }
    
    
    public ListNode tail(ListNode x) {
        while(x.next != null){
            x = x.next;
        } 
        return x;
    }
    
    public ListNode removeFirst(ListNode head) {
        return head.next;
    }
    
    public ListNode addFirst(ListNode main, ListNode tba) {
        tba.next = main;
        return tba;
    }
    
    public int getSize(ListNode head) {
        int s = 0;
        while(head != null) {
            s ++;
            head = head.next;
        }
        return s;
    }
}