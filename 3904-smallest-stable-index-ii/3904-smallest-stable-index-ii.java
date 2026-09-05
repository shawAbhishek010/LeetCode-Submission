class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int maxSoFar = -1;
        int ans = 0, max = 0;

        for (int i = 0; i < nums.length; i++) {
            maxSoFar = Math.max(maxSoFar, nums[i]);
            if (i == ans) max = maxSoFar;
            if (nums[i] < max - k)
                ans = i + 1;
        }

        return ans < nums.length ? ans : -1;
    }
}