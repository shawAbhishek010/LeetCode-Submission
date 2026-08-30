class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return ans;
        q.offer(root);
        while (!q.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int n = q.size();
            for (int i =0; i< n ; i++){
                TreeNode front = q.poll();
                list.add(front.val);
                if (front.left != null) q.offer(front.left);
                if (front.right != null) q.offer(front.right);
            }
            ans.add(list);
        }
        return ans;
    }
}


// class Solution {
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         List<List<Integer>> ans = new ArrayList<>();
//         if (root == null)
//             return ans;
//         helper(root, ans);
//         return ans;
//     }

//     public void helper(TreeNode root, List<List<Integer>> ans) {
//         Queue<Pair> q = new LinkedList<>();
//         q.add(new Pair(root, 0));
//         while (!q.isEmpty()) {
//             Pair p = q.remove();
//             TreeNode node = p.node;
//             int level = p.level;

//             // Create list for the current level 
//             if (ans.size() == level) {
//                 ans.add(new ArrayList<>());
//             }
//             ans.get(level).add(node.val);
//             if (node.left != null) {
//                 q.add(new Pair(node.left, level + 1));
//             }
//             if (node.right != null) {
//                 q.add(new Pair(node.right, level + 1));
//             }
//         }
//     }

//     class Pair {
//         TreeNode node;
//         int level;

//         Pair(TreeNode node, int level) {
//             this.node = node;
//             this.level = level;
//         }
//     }
// }