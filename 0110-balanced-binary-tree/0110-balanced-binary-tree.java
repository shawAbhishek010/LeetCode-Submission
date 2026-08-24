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
// class Solution {
//     public boolean isBalanced(TreeNode root) {
//         if(isValid(root))return true;
//         return false;
//     }
//     public boolean isValid(TreeNode root){
//         if(root==null)return true;
//         int leftLevel = level(root.left);
//         int rightLevel = level(root.right);
//         if(Math.abs(leftLevel-rightLevel)>1)return false;
//         return isValid(root.left) && isValid(root.right);
//     }
//      public int level(TreeNode root){
//         if(root==null)return 0;
//         return 1+Math.max(level(root.left),level(root.right));
//     }
// }

//OPTIMIZED VERSION>>>>>
class Solution {
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        level(root);
        return flag;
    }
     public int level(TreeNode root){
       if (root == null) return 0;
        int leftLevel =  level(root.left);
        int rightLevel = level(root.right);
        if(Math.abs(leftLevel-rightLevel)>1)flag = false;
        return 1 + Math.max(leftLevel,rightLevel);
    }
}