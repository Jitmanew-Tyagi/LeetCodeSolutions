/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> hm = new HashMap<>();
        Node temp = head;
        for(temp = head; temp != null; temp = temp.next) 
            hm.put(temp, new Node(temp.val));
        temp = head;
        Node nhead = hm.get(temp);
        for(temp = head; temp != null; temp = temp.next) {
            hm.get(temp).next = hm.get(temp.next);
            hm.get(temp).random = hm.get(temp.random);
        }
        return nhead;
    }
}