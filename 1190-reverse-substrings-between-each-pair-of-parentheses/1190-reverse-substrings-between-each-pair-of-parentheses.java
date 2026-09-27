class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        ArrayList<Integer> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<n;i++){
            if(s.charAt(i) == ')'){
                int idx = arr.get(arr.size() - 1);
                arr.remove(arr.size() - 1);
                String rvr = sb.substring(idx,sb.length());
                int len = rvr.length();
                sb.delete(sb.length() - len, sb.length());
                sb.append(new StringBuilder(rvr).reverse());
            }
            else if(s.charAt(i) == '('){
               arr.add(sb.length());
            }
            else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}