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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null) return ans;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()) {
            List<Integer> inter = new LinkedList<>();
            int size = que.size();
            while(size --> 0) {
                TreeNode out = que.remove();
                inter.add(out.val);
                if(out.left != null) que.add(out.left);
                if(out.right!= null) que.add(out.right);
            }
            ans.add(0, inter);
        }
        return ans;
    }
}