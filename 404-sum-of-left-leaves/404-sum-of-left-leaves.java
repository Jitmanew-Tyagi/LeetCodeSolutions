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
    public int sumOfLeftLeaves(TreeNode root) {
        return rec(root, false);
    }
    public int rec(TreeNode root, boolean isleft) {
        if(root == null) return 0;
        if(isleft && root.left == null && root.right == null) 
            return root.val;
        return rec(root.left, true) + rec(root.right, false);
    }
}