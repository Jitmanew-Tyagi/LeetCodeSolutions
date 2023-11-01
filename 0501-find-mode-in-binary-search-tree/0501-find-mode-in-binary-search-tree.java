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
        Map<Integer, Integer> hm = new HashMap<>();
        getMode(root, hm);
        int maxFreq = 0, idx = 0, count = 0;
        for(int key : hm.keySet()) {
            int f = hm.get(key);
            if(f > maxFreq) {
                maxFreq = f;
                count = 1;
            } else if(f == maxFreq) count ++;
        }
        int[] ans = new int[count];
        for(int key : hm.keySet()) {
            if(hm.get(key) == maxFreq) ans[idx ++] = key;
        }
        return ans;
    }
    
    public void getMode(TreeNode root, Map<Integer, Integer> hm) {
        if(root == null) return;
        hm.put(root.val, hm.getOrDefault(root.val, 0) + 1);
        if(root.left != null) getMode(root.left, hm);
        if(root.right != null) getMode(root.right, hm);
    }
}