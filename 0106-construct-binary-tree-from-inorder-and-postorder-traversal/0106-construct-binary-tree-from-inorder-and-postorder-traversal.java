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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        TreeNode ans = helper(inorder,postorder,0,n-1,0,n-1);
        return ans;
    }
    public TreeNode helper(int[] inorder, int[] postorder,int iLow,int iHigh,int pLow,int pHigh){
        if(pLow>pHigh || iLow>iHigh) return null;
        int r = 0;
        TreeNode root = new TreeNode(postorder[pHigh]);
        while(inorder[r]!=postorder[pHigh]){
            r++;
        }
        int leftSize = r-iLow;
        root.left = helper(inorder,postorder,iLow,r-1,pLow,pLow+leftSize-1);
        root.right = helper(inorder,postorder,r+1,iHigh,pLow+leftSize,pHigh-1);
        return root;
    }
}