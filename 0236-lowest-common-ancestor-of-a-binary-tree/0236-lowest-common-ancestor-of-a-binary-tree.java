/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pPath = ntrp(root, p);
        List<TreeNode> qPath = ntrp(root, q);
        
        int i = pPath.size() - 1, j = qPath.size() - 1;
        while(i >= 0 && j >= 0 && pPath.get(i) == qPath.get(j)){
            i --; j --;
        }
        return pPath.get(++ i);
    }
    
    public List<TreeNode> ntrp(TreeNode root, TreeNode node) {
        if(root == null || root == node) {
            List<TreeNode> base = new ArrayList<>();
            if(root != null) base.add(node);
            return base;
        }
        
        List<TreeNode> left = ntrp(root.left, node);
        if(left.size() > 0) {
            left.add(root);
            return left;
        }
        
        List<TreeNode> right = ntrp(root.right, node);
        if(right.size() > 0) {
            right.add(root);
            return right;
        }
        
        return new ArrayList<>();
    }
}