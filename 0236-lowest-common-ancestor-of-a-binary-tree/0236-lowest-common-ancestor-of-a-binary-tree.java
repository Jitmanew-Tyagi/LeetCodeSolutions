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
        List<TreeNode> ntrpForP = ntrp(root, p);
        List<TreeNode> ntrpForQ = ntrp(root, q);
        
        int i = ntrpForP.size() - 1;
        int j = ntrpForQ.size() - 1;
        
        while(i >= 0 && j >= 0 && ntrpForP.get(i) == ntrpForQ.get(j)) {
            i --;
            j --;
        }
        return ntrpForP.get(++ i);
    }
    
    public List<TreeNode> ntrp(TreeNode root, TreeNode node) {
        // BASE CASE\
        if(root == null || root.val == node.val) {
            List<TreeNode> base = new ArrayList<>();
            if(root != null) base.add(root);
            return base;
        }
        List<TreeNode> left = ntrp(root.left, node);
        List<TreeNode> right = ntrp(root.right, node);
        if(!left.isEmpty()) {
            left.add(root);
            return left;
        } else if(!right.isEmpty()) {
            right.add(root);
            return right;
        }
        return new ArrayList<>();
    }
}