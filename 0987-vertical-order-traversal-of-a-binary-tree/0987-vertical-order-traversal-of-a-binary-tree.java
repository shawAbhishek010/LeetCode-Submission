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
    List<pair> list = new ArrayList<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root, 0, 0);

        Collections.sort(list);

        int prevCol = Integer.MIN_VALUE;
        //creating blank arraylist and fill with equal column values
        for(pair p : list){
            if(p.col != prevCol){
                ans.add(new ArrayList<>());
                prevCol = p.col;
            }
            ans.get(ans.size() - 1).add(p.value);
        }
        return ans;
    }

    public void helper(TreeNode root, int col, int level){
        if(root == null) return;

        list.add(new pair(col, level, root.val));

        helper(root.left, col - 1, level + 1);
        helper(root.right, col + 1, level + 1);
    }

    class pair implements Comparable<pair> {
        int col;
        int level;
        int value;

        pair(int col, int level, int val){
            this.col = col;
            this.level = level;
            this.value = val;
        }

        public int compareTo(pair other){
            if(this.col != other.col)
                return this.col - other.col;

            if(this.level != other.level)
                return this.level - other.level;

            return this.value - other.value;
        }
    }
}