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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr =  new ArrayList<>();
        helper(root,targetSum,arr,ans);
        return ans;
    }
    public void helper(TreeNode root,int target,List<Integer> arr,List<List<Integer>> ans){
        if(root==null)return;
        
        arr.add(root.val);
        if(root.left==null && root.right==null){
            if(target==root.val)ans.add(new ArrayList<>(arr));
        }
        helper(root.left,target-root.val,arr,ans);
        helper(root.right,target-root.val,arr,ans);
        arr.remove(arr.size() - 1);
    }
}