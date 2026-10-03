class Solution {
    public int longestValidParentheses(String s) {
        int open = 0;
        int close = 0;
        int leftAns = 0;
        int rightAns = 0;
        //Left to Right
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                open++;
            } else if (ch == ')') {
                close++;
                if (close > open) {
                    open = 0;
                    close = 0;
                }
            }
            if (open == close) {
                leftAns = Math.max(leftAns, open + close);
            }
        }
        //Right to Left
        open = 0;
        close = 0;
        for (int i = s.length()-1;i>=0;i--) {
            char ch = s.charAt(i);
            if (ch == ')') {
                close++;
            } else if (ch == '(') {
                open++;
                if (open > close) {
                    open = 0;
                    close = 0;
                }
            }
            if (open == close) {
                rightAns = Math.max(rightAns, open + close);
            }
        }
        return Math.max(leftAns, rightAns);
    }
}