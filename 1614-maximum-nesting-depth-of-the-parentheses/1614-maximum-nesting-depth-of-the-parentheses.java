class Solution {
    public int maxDepth(String s) {
        Stack <Character> st = new Stack<>();
        int count = 0;
        int maxDepth = 0;
        for(char ch : s.toCharArray()){
            if(ch=='('){
                st.push('(');
                count++;
                maxDepth = Math.max(maxDepth,count);
            }
            else if(ch==')'){
                st.pop();
                count--;
            }
        }
        return maxDepth;
    }
}