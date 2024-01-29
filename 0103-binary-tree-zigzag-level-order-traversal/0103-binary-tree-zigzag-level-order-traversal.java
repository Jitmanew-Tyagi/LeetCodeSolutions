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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()) {
            int size = que.size();
            List<Integer> sublist = new ArrayList<>();
            while(size --> 0) {
                TreeNode out = que.remove();
                sublist.add(out.val);
                if(out.left != null) que.add(out.left);
                if(out.right != null) que.add(out.right);
            }
            ans.add(sublist);
        }
        for(int i = 1; i < ans.size(); i += 2) Collections.reverse(ans.get(i));
        return ans;
    }
}