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
    int maxPath = Integer.MIN_VALUE; 
    public int maxPathSum(TreeNode root) { 
        helper(root); 
        return maxPath; 
    } 
    public int helper(TreeNode root) { 
        if(root == null) return 0; 
        int left = helper(root.left); 
        int right = helper(root.right); 
        //All maxPath combinataions.......
        int maxLeftOrRight = Math.max(left, right);
        int maxOneNodeRoot = Math.max(root.val, root.val + maxLeftOrRight);
        int maxAll = Math.max(maxOneNodeRoot, left + root.val + right);
        maxPath = Math.max(maxPath, maxAll); 
        // returning the value if root was part of the answer
        return maxOneNodeRoot; 
    } 
}