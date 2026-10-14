class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > num * 9) return "";
        StringBuilder result = new StringBuilder();
        for(int i= 0;i<num;i++){
            if(sum>=9){
                result.append(9);
                sum = sum-9;
            }
            else{
                result.append(sum);
                sum = 0;
            }
            
        }
        return result.toString();
    }
}