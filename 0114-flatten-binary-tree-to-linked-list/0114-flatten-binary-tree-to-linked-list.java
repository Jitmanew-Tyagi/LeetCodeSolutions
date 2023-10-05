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
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode ans = new TreeNode(-1), temp = ans;
        List<Integer> nums = new ArrayList<>();
        rec(root, nums);
        for(int ele : nums) {
            temp.right = new TreeNode(ele);
            temp = temp.right;
        }
        if(root.left != null) root.left = null;
        root.right = ans.right.right;
    }
    
    public void rec(TreeNode root, List<Integer> nums){
        if(root == null) return;
        nums.add(root.val);
        rec(root.left, nums);
        rec(root.right, nums);
    }
}