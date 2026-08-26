
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
//------------>0(n^2)<-------------

// class Solution {
//     int count=0;
//     public int pathSum(TreeNode root, int targetSum) {
//         if(root==null)return 0;
//         helper(root,targetSum);
//         pathSum(root.left,targetSum);
//         pathSum(root.right,targetSum);
//         return count;
//     }
//     public void helper(TreeNode root,long target){
//         if(root==null)return;
//         if(root.val == target)count++;
//         helper(root.left,target-root.val);
//         helper(root.right,target-root.val);

//     }
// }

//------------>0(n)<-------------
class Solution {
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long,Integer> map = new HashMap<>();
        map.put(0L,1);
        helper(0L,root,targetSum,map);
        return count;
    }
    public void helper(long sum,TreeNode root,int targetSum,HashMap<Long,Integer> map){
        //base condn
        if(root==null)return;
        sum+=root.val;
        if(map.containsKey(sum-targetSum))count += map.get(sum - targetSum);
        if(!map.containsKey(sum)) map.put(sum,1);
        else{
            int value = map.get(sum);
            map.put(sum,value+1);
        }
        helper(sum,root.left,targetSum,map);
        helper(sum,root.right,targetSum,map);
        int value = map.get(sum);
        if(value == 1)map.remove(sum);
        else
        map.put(sum, value - 1);
    }
}