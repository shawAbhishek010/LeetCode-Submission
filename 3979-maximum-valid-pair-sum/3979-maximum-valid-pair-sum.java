class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int max = Integer.MIN_VALUE;
        int maxArr[] = new int[n];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            maxArr[i] = max;
        }
        for (int i = k; i < n; i++) {
            int idx = i-k;
            ans = Math.max(ans,nums[i]+maxArr[idx]);
        }
        return ans;
    }
}