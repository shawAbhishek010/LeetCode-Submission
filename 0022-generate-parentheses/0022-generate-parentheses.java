class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(sb,list,0,0,n);
        return list;
    }
    public void helper(StringBuilder sb ,ArrayList<String> list,int x, int y,int n){
       // Base condition
        if (x == n && y == n) {
        if (!list.contains(sb.toString())) list.add(sb.toString());
            return;
        }
        if (x < n) {
            sb.append('(');//use "("
            helper(sb, list, x + 1, y, n);// Explore
            sb.deleteCharAt(sb.length() - 1);//backTrack
        }
        if (y < x) {
            sb.append(')');//use ")"
            helper(sb, list, x, y + 1, n);// Explore
            sb.deleteCharAt(sb.length() - 1);//backTrack
        }
    }
}