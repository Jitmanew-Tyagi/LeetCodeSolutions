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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder one = new StringBuilder(), two = new StringBuilder();
        getLeafSeq(root1, one);
        getLeafSeq(root2, two);
        return one.toString().equals(two.toString());
    }
    
    public void getLeafSeq(TreeNode root, StringBuilder vals) {
        if(root.left == null && root.right == null) {
            vals.append(root.val).append(".");
            return;
        }
        if(root.left != null) getLeafSeq(root.left, vals);
        if(root.right != null) getLeafSeq(root.right, vals);
    }
}