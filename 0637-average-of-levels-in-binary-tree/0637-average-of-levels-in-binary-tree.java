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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double>  result = helper(root);
        return result;
    }
    public List<Double> helper(TreeNode root){
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return ans;
        q.offer(root);
        while (!q.isEmpty()){
            int n = q.size();
            double avg = 0;
            for (int i =0; i< n ; i++){
                TreeNode front = q.poll();
                avg = avg + front.val;
                if (front.left != null) q.offer(front.left);
                if (front.right != null) q.offer(front.right);
                if(i==n-1)avg = avg/n;
            }
            ans.add(avg);
        }
        return ans;
    }
}