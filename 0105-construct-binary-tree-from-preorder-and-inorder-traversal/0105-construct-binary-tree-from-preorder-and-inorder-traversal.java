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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int m = preorder.length;
        TreeNode ans = helper(preorder,inorder,0,m-1,0,m-1);
        return ans;

    }
     public TreeNode helper(int[] preorder, int[] inorder,int prL,int prH, int inL,int inH){
        if(prL>prH || inL>inH) return null;
        TreeNode root = new TreeNode(preorder[prL]);
        int r = 0;
        while(inorder[r]!=preorder[prL])r++;
         int LSTsize = r-inL;
         root.left = helper(preorder,inorder,prL+1,prL+LSTsize,inL,r-1);
         root.right =helper(preorder,inorder,prL+LSTsize+1,prH,r+1,inH);
         return root;
     }
}