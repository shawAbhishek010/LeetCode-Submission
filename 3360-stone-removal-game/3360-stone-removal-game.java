class Solution {
    public boolean canAliceWin(int n) {
        int turn  = n / 10;
        int take = 10;
        boolean flag = true;
        int count = 0;
        if(turn<1)return false;
        while(n>=take){
            n = n - take; 
            take--;
            count++;
            if(count%2!=0)flag = true;
            else flag = false;
        }
        if(flag == false)return false;
        return true;
    }
} 