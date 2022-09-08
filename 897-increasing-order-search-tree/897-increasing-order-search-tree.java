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
    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans = new TreeNode(-1), rv = ans, temp = root;
        while(temp != null) {
            if(temp.left != null) {
                TreeNode rmost = getRightMost(temp.left, temp);
                if(rmost.right == null) {
                    rmost.right = temp;
                    temp = temp.left;
                } else {
                    ans.right = new TreeNode(temp.val);
                    temp = temp.right;
                    ans = ans.right;
                }
            } else {
                ans.right = new TreeNode(temp.val);
                temp = temp.right; ans = ans.right;
            }
        }
        return rv.right;
    }
    
    public TreeNode getRightMost(TreeNode node, TreeNode root) {
        while(node.right != null && node.right != root) node = node.right;
        return node;
    }
    
}








