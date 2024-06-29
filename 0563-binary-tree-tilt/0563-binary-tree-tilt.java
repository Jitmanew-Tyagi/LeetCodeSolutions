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
    public int findTilt(TreeNode root) {
        return root == null ? 0 : findTilt(root.left) 
            + findTilt(root.right) 
            + Math.abs(sum(root.left) - sum(root.right));
    }
    
    public int sum(TreeNode root) {
        if(root == null) return 0;
        int ans = root.val;
        ans += sum(root.left);
        ans += sum(root.right);
        return ans;
    }
}