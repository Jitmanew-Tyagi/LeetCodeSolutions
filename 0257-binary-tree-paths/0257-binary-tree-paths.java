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
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return new ArrayList<>();
        if(root.left == null && root.right == null) {
            List<String> base = new ArrayList<>();
            base.add(root.val + "");
            return base;
        }
        List<String> ans = new ArrayList<>();
        for(String f : binaryTreePaths(root.left)) ans.add(root.val + "->" + f);
        for(String f : binaryTreePaths(root.right)) ans.add(root.val + "->" + f);
        return ans;
    }
}