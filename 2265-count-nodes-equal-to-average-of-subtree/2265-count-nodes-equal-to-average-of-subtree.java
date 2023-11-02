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
    public int averageOfSubtree(TreeNode root) {
        int[] ans = rec(root);
        return ans[2];
    }
    
    public int[] rec(TreeNode root) {
        int sum = root.val, size = 1, eac = 0;
        if(root.left != null) {
            int[] left = rec(root.left);
            sum += left[0];
            size += left[1];
            eac += left[2];
        }
        if(root.right != null) {
            int[] right = rec(root.right);
            sum += right[0];
            size += right[1];
            eac += right[2];
        }
        
        if((sum / size) == root.val) eac += 1;
        return new int[]{sum, size, eac};
    }
}