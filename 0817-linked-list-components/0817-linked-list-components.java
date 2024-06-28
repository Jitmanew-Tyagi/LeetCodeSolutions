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
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> hs = new HashSet<>();
        for(int ele : nums) hs.add(ele);
        
        ListNode temp = head;
        int ans = hs.size();
        while(temp != null & temp.next != null) {
            if(hs.contains(temp.val) && hs.contains(temp.next.val)) ans --;
            temp = temp.next;
        }
        return ans;
    }
}