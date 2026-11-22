class Solution {
    public boolean checkString(String s) {
        int n = s.length();
        for(int i = 0;i<n-1;i++){
            int curr = s.charAt(i);
            int next = s.charAt(i+1);
            if(curr>next)return false;
        }
        return true;
    }
}