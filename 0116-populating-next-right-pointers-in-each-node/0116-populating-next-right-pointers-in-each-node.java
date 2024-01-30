/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()) {
            int size = que.size();
            while(size --> 0) {
                Node out = que.remove();
                if(size > 0) out.next = que.peek();
                else out.next = null;
                if(out.left != null) que.add(out.left);
                if(out.right != null) que.add(out.right);
            }
        }
        return root;
    }
}