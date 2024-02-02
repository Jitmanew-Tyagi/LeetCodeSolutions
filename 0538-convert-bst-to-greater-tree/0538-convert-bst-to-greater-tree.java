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
    public TreeNode convertBST(TreeNode root) {
        return convertBSTHelper(root, new int[1]);
    }
    
    public TreeNode convertBSTHelper(TreeNode root, int[] sum) {
        if(root == null) return null;
        convertBSTHelper(root.right, sum);
        root.val += sum[0];
        sum[0] = root.val;
        convertBSTHelper(root.left, sum);
        return root;
    }
}