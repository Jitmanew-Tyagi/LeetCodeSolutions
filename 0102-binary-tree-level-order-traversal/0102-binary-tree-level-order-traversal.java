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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        List<List<Integer>> ans = new ArrayList<>();
        while(!que.isEmpty()) {
            int size = que.size();
            List<Integer> list = new ArrayList<>();
            while(size --> 0) {
                TreeNode out = que.remove();
                list.add(out.val);
                if(out.left != null) que.add(out.left);
                if(out.right != null) que.add(out.right);
            }
            ans.add(list);
        }
        return ans;
    }
}