class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int minRemove = 0;
        int openBracket = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                openBracket++;
            } else if (ch == ')') {
                if (openBracket > 0)
                    openBracket--;
                else
                    minRemove++;
            }
        }
        minRemove += openBracket;
        helper(0, 0, sb, ans, s, minRemove);
        return ans;
    }

    public void helper(int idx, int count, StringBuilder sb, List<String> ans, String s, int minRemove) {
        //Base cond
        if (idx == s.length()) {
            if (count == 0 && minRemove == 0) {
                if (!ans.contains(sb.toString()))
                    ans.add(sb.toString());
            }
            return;
        }
        char ch = s.charAt(idx);
        int oldCount = count;
        if (ch == '(')
            count++;
        else if (ch == ')') {
            count--;
        }
        if (count >= 0) {
            sb.append(ch);
            helper(idx + 1, count, sb, ans, s, minRemove);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (minRemove > 0 && (ch == '(' || ch == ')'))
            helper(idx + 1, oldCount, sb, ans, s, minRemove - 1);
    }
}