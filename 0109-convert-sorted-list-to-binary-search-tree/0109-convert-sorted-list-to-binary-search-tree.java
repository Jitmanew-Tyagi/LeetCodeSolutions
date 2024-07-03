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
        return rec(head, null);
    }
    
    public static TreeNode rec(ListNode head, ListNode tail) {
        if(head == tail) return null;
        ListNode s = head, f = head;
        while(f != tail && f.next != tail) {
            s = s.next;
            f = f.next.next;
        }
        TreeNode root = new TreeNode(s.val);
        root.left = rec(head, s);
        root.right = rec(s.next, tail);
        return root;
    }
}