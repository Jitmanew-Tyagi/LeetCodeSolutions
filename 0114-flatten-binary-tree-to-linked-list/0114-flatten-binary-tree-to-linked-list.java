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
        rec(root);
    }
    
    public TreeNode rec(TreeNode root){
        if(root.left == null && root.right == null)  
            return root;
        if(root.right == null) {
            rec(root.left);
            root.right = root.left;
            root.left = null;
            return root;
        }
        if(root.left == null) {
            rec(root.right);
            return root;
        }
        rec(root.left);
        rec(root.right);
        TreeNode temp = root.right;
        root.right = root.left;
        getTailNode(root.right).right = temp;
        root.left = null;
        return root;
    }
    
    public TreeNode getTailNode(TreeNode root) {
        TreeNode temp = root;
        while(temp.right != null) temp = temp.right;
        return temp;
    }
}