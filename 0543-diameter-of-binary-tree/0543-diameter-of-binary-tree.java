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

//o(n^2)worst solution.........
// class Solution {
//     public int level(TreeNode root) {
//         if (root == null)
//             return 0;
//         return 1 + Math.max(level(root.left), level(root.right));
//     }

//     public int diameterOfBinaryTree(TreeNode root) {
//         if (root == null)
//             return 0;
//         int rootDia = level(root.left) + level(root.right);
//         int leftDia = diameterOfBinaryTree(root.left);
//         int rightDia = diameterOfBinaryTree(root.right);
//         return Math.max(rootDia, Math.max(leftDia, rightDia));
//     }
// }

//Memoizing this worst soln to reduced tc..
// class Solution {
//     HashMap<TreeNode, Integer> dpMap = new HashMap<>();;

//     public int level(TreeNode root) {
//         if (root == null)
//             return 0;
//         if (dpMap.containsKey(root))
//             return dpMap.get(root);
//         int leftLevel = level(root.left);
//         int rightLevel = level(root.right);
//         dpMap.put(root, 1 + Math.max(leftLevel, rightLevel));
//         return dpMap.get(root);
//     }

//     public int diameterOfBinaryTree(TreeNode root) {
        
//         if (root == null)
//             return 0;
//         int rootDia = level(root.left) + level(root.right);
//         int leftDia = diameterOfBinaryTree(root.left);
//         int rightDia = diameterOfBinaryTree(root.right);
//         return Math.max(rootDia, Math.max(leftDia, rightDia));
//     }
// }


// Most optimized Solution.........(This can be said as tabulation)

class Solution {
    int maxDia = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        level(root);
        return maxDia;
    }
    public int level(TreeNode root){
        if(root==null)return 0;
        int leftDia =level(root.left);
        int rightDia =level( root.right);
        int rootDia = leftDia + rightDia;
        maxDia = Math.max(rootDia,maxDia);
        return 1+Math.max(leftDia,rightDia);
    }
}