class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1; 
        int hleft = Integer.MAX_VALUE, hright = Integer.MAX_VALUE;
        if(root.left != null) hleft = minDepth(root.left);
        if(root.right != null) hright = minDepth(root.right);
        return Math.min(hleft, hright) + 1;
    }
}