/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            Node prev = null;
            for(int i = 0; i < size; i++) {
                Node rmv = q.poll();
                if(prev != null) {
                    prev.next = rmv;
                }
                prev = rmv;
                if(rmv.left != null) {
                    q.offer(rmv.left);
                }
                if(rmv.right != null) {
                    q.offer(rmv.right);
                }
                if(i==size-1)rmv.next = null;
            }
        }
        return root;
    }
}