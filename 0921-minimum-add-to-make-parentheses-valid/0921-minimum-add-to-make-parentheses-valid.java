class Solution {
    public int minAddToMakeValid(String s) {
        int n = s.length();
        int openBracket = 0;
        int minAns = 0;
        for(int i = 0;i<n;i++){
            char ch = s.charAt(i);
            if(ch=='(') openBracket++;
            else {
                openBracket--;
                if(openBracket<0){
                    minAns = 1+minAns;
                    openBracket = 0;
                }
            }
        }
        return openBracket+minAns;
    }
}