/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()) {
            int size = que.size();
            List<Integer> subList = new ArrayList<>();
            while(size --> 0) {
                Node out = que.remove();
                subList.add(out.val);
                for(Node child : out.children) que.add(child);
            }
            ans.add(subList);
        }
        return ans;
    }
}