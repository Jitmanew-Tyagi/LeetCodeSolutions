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
    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>(), ans = new ArrayList<>();
        inorder(root, list);
        
        int cs = 0, ms = 0, cn = 0;
        for(int ele : list) {
            if(ele == cn) cs ++;
            else {
                cs = 1;
                cn = ele;
            }
            
             if(cs > ms) {
                ans = new ArrayList<>();
                ms = cs;
            }
            if(cs == ms) ans.add(cn);
            
        }
        int idx = 0, modes[] = new int[ans.size()];
        for(int ele : ans) modes[idx ++] = ele;
        return modes;
    }
    
    public void inorder(TreeNode root, List<Integer> ans) {
        if(root == null) return;
        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }
}











