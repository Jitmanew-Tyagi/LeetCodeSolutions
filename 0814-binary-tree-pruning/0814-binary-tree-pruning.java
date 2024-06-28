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
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) return null;
        TreeNode lst = pruneTree(root.left);
        TreeNode rst = pruneTree(root.right);
        if(lst == null && rst == null && root.val == 0) return null;
        root.left = lst;
        root.right = rst;
        return root;
    }
}