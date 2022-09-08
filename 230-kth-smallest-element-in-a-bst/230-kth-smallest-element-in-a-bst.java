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
    public TreeNode retrm(TreeNode node, TreeNode curr) {
        while(node.right != null && node.right != curr) node = node.right;
        return node;
    }
    public int kthSmallest(TreeNode root, int k) {
        TreeNode curr = root;
        while(k > 0) {
            if(curr.left != null) {
                TreeNode rm = retrm(curr.left, curr);
                if(rm.right == null) {
                    rm.right = curr;
                    curr = curr.left;
                } else {
                    k--;
                    if(k == 0) return curr.val;
                    rm.right = null;
                    curr = curr.right;
                }
            } else {
                k --;
                if(k == 0) return curr.val;
                curr = curr.right;
            }
        }
        return curr.val;
    }
}