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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        List<List<Integer>> levelOrder = new ArrayList<>();
        while(!que.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = que.size();
            while(size --> 0) {
                TreeNode out = que.remove();
                temp.add(out.val);
                if(out.left != null) que.add(out.left);
                if(out.right != null) que.add(out.right);
            }
            levelOrder.add(temp);
        }
        List<Integer> order = new ArrayList<>();;
        for(int i = 0; i < levelOrder.size(); i ++) {
            if(i % 2 == 1) Collections.reverse(levelOrder.get(i));
            for(int j : levelOrder.get(i)) order.add(j);
        }
        que.add(root);
        int idx = 0;
        while(!que.isEmpty()) {
            int size = que.size();
            while(size --> 0) {
                TreeNode out = que.remove();
                out.val = order.get(idx ++);
                if(out.left != null) que.add(out.left);
                if(out.right != null) que.add(out.right);
            }
        }
        return root;
    }
}