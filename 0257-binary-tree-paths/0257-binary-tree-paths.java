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
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        List<String> ans = new ArrayList<>();
        if(left.size() > 0) for(String s : left) ans.add(root.val + "->" + s);
        if(right.size() > 0) for(String s : right) ans.add(root.val + "->" + s);
        return ans;
    }
}