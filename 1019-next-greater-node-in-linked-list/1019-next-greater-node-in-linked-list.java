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
    public int[] nextLargerNodes(ListNode head) {
        ListNode p = null, c = head, n = head;
        int size = 0;
        while(c != null) {
            n = c.next;
            c.next = p;
            p = c; 
            c = n;
            size ++;
        }
        return nextGreater(p, size);
    }
    
    public int[] nextGreater(ListNode head, int n) {
        int ans[] = new int[n], idx = n - 1;
        Stack<Integer> st = new Stack<>();
        ListNode temp = head;
        while(temp != null) {
            while(!st.isEmpty() && temp.val >= st.peek()) st.pop();
            ans[idx --] = st.isEmpty() ? 0 : st.peek();
            st.push(temp.val);
            temp = temp.next;
        }
        return ans;
    }
}