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
    int level;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        List<TreeNode> arr = new ArrayList<>();
        level = findLevel(root);
        helper(root, 1, arr);
        TreeNode ans = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            ans = lowestCommonAncestor(root, ans, arr.get(i));
        }
        return ans;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val == p.val || root.val == q.val) return root;//both in different side 
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null)return root;//****both in same treeSide
        return left != null ? left : right;//both in same side but findLevel different
    }
    public int findLevel(TreeNode root){
        if(root==null)return 0;
        return 1 + Math.max(findLevel(root.left),findLevel(root.right));
    }
    public void helper(TreeNode root,int var,List<TreeNode> arr){
        if(root==null)return;
        if(var==level)arr.add(root);
        helper(root.left,var+1,arr);
        helper(root.right,var+1,arr);
    }
}
