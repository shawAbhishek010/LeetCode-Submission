// class Solution {
//     public int scoreOfParentheses(String s) {
//         int n = s.length();
//         int open = 0;
//         int close = 0;
//         int score = 0;
//         for (int i = 0; i < n; i++) {
//             char ch = s.charAt(i);
//             if (ch == '(') {
//                 if (close > 0) {
//                     close = 0;                     // WRONG APPROACH............
//                     open = 0;
//                 }
//                 open += 1;
//             } else if (ch == ')') {
//                 close += 1;
//                 if (open == close && i!=n-1)
//                     score = score + 1;
//                 else if (close == 1)
//                     score = score + 1;
//                 else {
//                     score = score * 2;
//                 }
//             }
//         }
//         return score;
//     }
// }

class Solution {
    public int scoreOfParentheses(String s) {
        int score = 0;
        int openBracket = 0;

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                openBracket++;
            }
            else {
                openBracket--;
                if(s.charAt(i - 1) == '(') {
                    score += Math.pow(2, openBracket);
                }
            }
        }

        return score;
    }
}