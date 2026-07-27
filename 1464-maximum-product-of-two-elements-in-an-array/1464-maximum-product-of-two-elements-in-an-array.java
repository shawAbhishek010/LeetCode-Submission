class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int a = nums[n-1], b=nums[n-2];
        int ans = (a-1)*(b-1);
        return ans;
    }
}