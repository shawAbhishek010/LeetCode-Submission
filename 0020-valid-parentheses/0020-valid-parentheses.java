class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='('){
                st.push(')');
            }
            else if(ch=='{'){
                 st.push('}');
            }
            else if(ch=='['){
                st.push(']');
            }
            else if(ch==')' || ch=='}' || ch==']'){
                if(st.isEmpty() || st.peek()!=ch)return false;
                else{
                    st.pop();
                }
            }
        }
        if(!st.isEmpty())return false;
        return true;
    }
}