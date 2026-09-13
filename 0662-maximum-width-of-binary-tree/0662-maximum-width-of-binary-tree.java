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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        int maxWidth = 0;
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()) {
            int size = q.size();
            int first = 0;
            int last = 0;
            for(int i = 0; i < size; i++) {
                Pair p = q.poll();
                TreeNode node = p.root;
                int idx = p.idx;
                if(i == 0) first = idx;
                if(i == size - 1) last = idx;
                if(node.left != null) {
                    q.offer(new Pair(node.left, 2 * idx + 1));
                }
                if(node.right != null) {
                    q.offer(new Pair(node.right, 2 * idx + 2));
                }
            }
            int width = last - first + 1;
            maxWidth = Math.max(maxWidth, width);
        }
        return maxWidth;
    }

    class Pair {
        TreeNode root;
        int idx;

        Pair(TreeNode root, int idx) {
            this.root = root;
            this.idx = idx;
        }
    }
}