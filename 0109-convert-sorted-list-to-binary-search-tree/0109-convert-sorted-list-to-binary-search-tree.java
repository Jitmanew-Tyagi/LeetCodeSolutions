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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        int size = getSize(head);
        return getBST(head, 0, size - 1);
    }
    
    public TreeNode getBST(ListNode head, int s, int e){
        if(s > e) return null;
        if(s == e) return new TreeNode(getNodeAt(head, s));
        int mid = (s + e) % 2 == 0 ? (s + e) / 2 : ((s + e) / 2) + 1;
        return new TreeNode(getNodeAt(head, mid), getBST(head, s, mid - 1), getBST(head, mid + 1, e));
    }
    
    public int getNodeAt(ListNode head, int idx) {
        ListNode temp = head;
        while(idx --> 0) temp = temp.next;
        return temp.val;
    }
    
    public int getSize(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while(temp != null) {
            temp = temp.next;
            size ++;
        }
        return size;
    }
}