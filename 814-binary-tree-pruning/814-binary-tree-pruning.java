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
        TreeNode lsa = pruneTree(root.left);
        TreeNode rsa = pruneTree(root.right);
        root.left = lsa;
        root.right = rsa;
        if(lsa == null && rsa == null && root.val == 0) return null;
        return root;
    }
}