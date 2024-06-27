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
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for(int ele : inorderTraversal(root.left)) ans.add(ele);
        ans.add(root.val);
        for(int ele : inorderTraversal(root.right)) ans.add(ele);
        return ans;
    }
}