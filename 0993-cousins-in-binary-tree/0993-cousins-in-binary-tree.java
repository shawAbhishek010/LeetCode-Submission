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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return false;
        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = q.remove();
                list.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
                if (node.left != null && node.right != null) {
                     if ((node.left.val == x && node.right.val == y)||(node.left.val == y && node.right.val == x))
                    return false;
                }
                if(i==n-1){
                    if(list.contains(x) && !list.contains(y))return false;
                    if(list.contains(y) && !list.contains(x))return false;
                }
            }
        }
        return true;
    }
}