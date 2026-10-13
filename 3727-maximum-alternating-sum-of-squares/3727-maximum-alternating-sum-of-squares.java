class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0)
                nums[i] *= -1;
        }
        Arrays.sort(nums);
        int i = 0;
        int j = n-1;
        long score = 0;
    
        while(j>=i){
                score = score + 1L*nums[j]*nums[j];
                if(i<j)score = score - 1L*nums[i]*nums[i];
                i++;
                j--;
            
        }
    return score;
    }
}