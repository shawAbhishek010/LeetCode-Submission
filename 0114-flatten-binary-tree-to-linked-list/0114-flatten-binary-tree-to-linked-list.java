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
    public void flatten(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        helper(root,ans);
        for(int i=0;i<ans.size()-1;i++){
            root.left = null;
            root.right = ans.get(i+1);
            root = ans.get(i+1);
        }
    }
    public void helper(TreeNode root,List<TreeNode> ans ){
        if(root==null) return;
        ans.add(root);
        helper(root.left,ans);
        helper(root.right,ans);
    }
}