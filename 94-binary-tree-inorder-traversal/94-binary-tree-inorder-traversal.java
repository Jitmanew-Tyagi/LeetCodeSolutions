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
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode node = root;
        List<Integer> ans = new ArrayList<>();
        while(node != null) {
            if(node.left == null) {
                ans.add(node.val);
                node = node.right;
            }
            else {
                TreeNode rm = getRightMost(node.left, node);
                if(rm.right == node) {
                    ans.add(node.val);
                    rm.right = null;
                    node = node.right;
                } else if(rm.right == null) {
                    rm.right = node;
                    node = node.left;
                }
            }
        }
        return ans;
    }
    
    public TreeNode getRightMost(TreeNode node, TreeNode root) {
        return (node.right == null || node.right == root) ? node : getRightMost(node.right, root);
    }
}