class Solution {
    public int scoreOfString(String s) {
        int n = s.length();
        int ans = 0;
        for(int i=0;i<n-1;i++){
            int curr = s.charAt(i);
            int nxt = s.charAt(i+1);
            ans = ans + Math.abs(curr-nxt);
        }
        return ans;
    }
}