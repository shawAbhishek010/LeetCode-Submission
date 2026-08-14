class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int n = s.length();
        int  maxLen = 0;
        while(j<n){
            char ch = s.charAt(j);
            if(!map.containsKey(ch)){
                map.put(ch,1);
            }
            else{
                int val = map.get(ch);
                map.put(ch,val+1);
                while(map.get(ch)>2){
                    char left = s.charAt(i);
                    int leftVal = map.get(left);
                    map.put(left, leftVal - 1);
                    i++;
                }
               
            }
            maxLen = Math.max(maxLen,j-i+1);

           j++; 
        }
        return maxLen;
    }
}