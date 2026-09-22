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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
         int n = preorder.length;
        TreeNode ans = helper(preorder,postorder,0,n-1,0,n-1);
        return ans;
    }
    public TreeNode helper(int[] preorder, int[] postorder,int preLow,int preHigh,int postLow,int postHigh){
        if(preLow>preHigh || postLow>postHigh) return null;
        int r = postLow;
        TreeNode root = new TreeNode(preorder[preLow]);
         if (preLow == preHigh) {
            return root;
        }
        while (postorder[r] != preorder[preLow + 1]) {
            r++;
        }
        int leftSize = r-postLow+1;
        root.left = helper(preorder,postorder,preLow+1,preLow+leftSize,postLow,r);
        root.right = helper(preorder,postorder,preLow+leftSize+1,preHigh,r+1,postHigh-1);
        return root;
    }
}