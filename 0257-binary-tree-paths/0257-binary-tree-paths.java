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
        List<String> ans = new ArrayList<>();
        if(root == null) return ans;
        if(root.left == null && root.right == null) {
            ans.add("" + root.val);
            return ans;
        }
        for(String lp : binaryTreePaths(root.left)) ans.add(root.val + "->" + lp);
        for(String rp : binaryTreePaths(root.right)) ans.add(root.val + "->" + rp);
        return ans;
    }
}