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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()) {
            int size = que.size();
            for(int i = 1; i <= size; i ++) {
                TreeNode out = que.remove();
                if(i == size) ans.add(out.val);
                if(out.left != null) que.add(out.left);
                if(out.right != null) que.add(out.right);
            }
        }
        return ans;
    }
}