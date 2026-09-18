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
 
 //using DFS
// class Solution {
//     public TreeNode invertTree(TreeNode root) {
//         if(root==null) return null;
//         TreeNode temp = root.left;
//         root.left = root.right;
//         root.right = temp;
//         invertTree(root.left);
//         invertTree(root.right);
//     return root;
//     }
// }
// using BFS
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        helper(root, q);

        return root;
    }

    public void helper(TreeNode root, Queue<TreeNode> q) {
        while(!q.isEmpty()) {
            TreeNode node = q.remove();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if(node.left != null)
                q.offer(node.left);
            if(node.right != null)
                q.offer(node.right);
        }
    }
}
