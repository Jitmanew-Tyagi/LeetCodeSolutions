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
    public void flatten(TreeNode root) {
        if(root == null) return;
        if(root.left == null) {
            flatten(root.right);
            return;
        }
        if(root.right == null) {
            flatten(root.left);
            root.right = root.left;
            root.left = null;
            return;
        }
        
        flatten(root.left);
        flatten(root.right);
        
        TreeNode temp = root.right;
        root.right = root.left;
        getTailNode(root.left).right = temp;
        root.left = null;
    }
    
    public TreeNode getTailNode(TreeNode root) {
        while(root.right != null) root = root.right;
        return root;
    }
}