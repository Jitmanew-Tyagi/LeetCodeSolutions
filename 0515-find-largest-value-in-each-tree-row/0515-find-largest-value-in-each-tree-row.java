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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()) {
            int size = que.size(), max = que.peek().val;
            while(size --> 0) {
                TreeNode out = que.remove();
                max = Math.max(max, out.val);
                if(out.left != null) que.add(out.left);
                if(out.right != null) que.add(out.right);
            }
            ans.add(max);
        }
        return ans;
    }
}