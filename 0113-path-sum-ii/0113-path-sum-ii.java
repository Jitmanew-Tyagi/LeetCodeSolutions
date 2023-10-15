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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return ans;
        getAns(root, targetSum, 0, new ArrayList<>());
        return ans;
    }
    
    public List<List<Integer>> ans = new ArrayList<>();
    
    public void getAns(TreeNode root, int target, int sum, List<Integer> curr) {
        if(sum + root.val == target && root.left == null && root.right == null) {
            curr.add(root.val);
            ans.add(new ArrayList<>(curr));
            curr.remove(curr.size() - 1);
            return;
        }
        
        if(root.left != null) {
            curr.add(root.val);
            getAns(root.left, target, sum + root.val, curr);
            curr.remove(curr.size() - 1);
        }
        if(root.right != null) {
            curr.add(root.val);
            getAns(root.right, target, sum + root.val, curr);
            curr.remove(curr.size() - 1);
        }
        
    } 
}