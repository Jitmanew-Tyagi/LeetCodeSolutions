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
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<Pair> pq = new PriorityQueue<>();
        for(int i = 0; i < lists.length; i ++) {
            int val = getListHead(lists, i);
            if(val != Integer.MIN_VALUE) pq.add(new Pair(val, i));
        }
        
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while(!pq.isEmpty()) {
            Pair out = pq.remove();
            temp.next = new ListNode(out.val);
            temp = temp.next;
            int val = getListHead(lists, out.idx);
            if(val != Integer.MIN_VALUE) pq.add(new Pair(val, out.idx));
        }
        return head.next;
    }
    
    public int getListHead(ListNode[] lists, int k) {
        int ans = Integer.MIN_VALUE;
        if(lists[k] == null) return ans;
        ans = lists[k].val;
        lists[k] = lists[k].next;
        return ans;
    }
    
    class Pair implements Comparable<Pair> {
        int val;
        int idx;
        
        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
        
        public int compareTo(Pair other) {
            return this.val - other.val;
        }
    }
}