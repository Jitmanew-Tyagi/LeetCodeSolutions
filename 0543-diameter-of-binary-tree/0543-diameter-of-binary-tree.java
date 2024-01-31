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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int selfDiam = height(root.left) + height(root.right) + 2;
        int diamLeft = diameterOfBinaryTree(root.left);
        int diamRight = diameterOfBinaryTree(root.right);
        
        return Math.max(selfDiam, Math.max(diamLeft, diamRight));
    }
    
    public int height(TreeNode root) {
        return root == null ? -1 : Math.max(height(root.left), height(root.right)) + 1;
     }
}