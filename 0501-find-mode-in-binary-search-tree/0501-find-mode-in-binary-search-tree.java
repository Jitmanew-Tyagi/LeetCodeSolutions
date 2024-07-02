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
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        
        List<Integer> arr = new ArrayList<>();
        int cs = 0, ms = 0, cn = 0;
        for(int ele : list) {
            if(ele == cn) cs ++;
            else {
                cs = 1;
                cn = ele;
            }
            if(cs > ms) {
                arr.clear();
                ms = cs;
            }
            
            if(cs == ms) {
                arr.add(ele);
            }
        }
        
        int idx = 0, ans[] = new int[arr.size()];
        for(int ele : arr) ans[idx ++] = ele;
        return ans;
    }
    
    public void inorder(TreeNode root, List<Integer> ans) {
        if(root == null) return;
        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }
}