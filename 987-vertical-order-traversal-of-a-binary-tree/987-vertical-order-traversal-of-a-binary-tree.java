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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        TreeMap<Integer, TreeMap<Integer, PriorityQueue>> map = new TreeMap<>();
        TreeNode curr = root;
        Node base = new Node(curr, 0, 0);
        Queue<Node> que = new LinkedList<>();
        que.add(base);
        
        while(!que.isEmpty()) {
            Node rem = que.remove();
            if(!map.containsKey(rem.vert)) 
                map.put(rem.vert, new TreeMap<Integer, PriorityQueue>());
            if(!map.get(rem.vert).containsKey(rem.hor))
                map.get(rem.vert).put(rem.hor, new PriorityQueue<Integer>());
            map.get(rem.vert).get(rem.hor).add(rem.node.val);
            if(rem.node.left != null) 
                que.add(new Node(rem.node.left, rem.vert - 1, rem.hor + 1));
            if(rem.node.right != null) 
                que.add(new Node(rem.node.right, rem.vert + 1, rem.hor + 1));
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(Integer i : map.keySet()) {
            ans.add(new ArrayList<>());
            TreeMap<Integer, PriorityQueue> tbt = map.get(i);
            for(Integer j : tbt.keySet()) {
                PriorityQueue<Integer> pq = tbt.get(j);
                while(!pq.isEmpty()) ans.get(ans.size() - 1).add(pq.remove());
            }
        }
        return ans;
    }
    
    class Node {
        TreeNode node;
        int vert, hor; //linewise
        Node(TreeNode node, int vert, int hor){
            this.node = node;
            this.vert = vert;
            this.hor = hor;
        }
    }
}