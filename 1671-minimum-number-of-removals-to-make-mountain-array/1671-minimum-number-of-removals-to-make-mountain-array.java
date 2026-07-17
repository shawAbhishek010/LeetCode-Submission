class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int dp1[] = new int[n];
        int dp2[] = new int[n];
        dp1[0] = 1;
        dp2[n - 1] = 1;
        for (int a = 1, b = n - 2; a < n && b >= 0; a++, b--) {
            int LeftmaxLen = 1;
            int RightmaxLen = 1;
            for (int j = a - 1, k = b + 1; j >= 0 && k < n; j--, k++) {
                if (nums[j] < nums[a]) {
                    int len = dp1[j] + 1;
                    LeftmaxLen = Math.max(LeftmaxLen, len);
                }
                dp1[a] = LeftmaxLen;

                if (nums[k] < nums[b]) {
                    int len = dp2[k] + 1;
                    RightmaxLen = Math.max(RightmaxLen, len);
                }
                dp2[b] = RightmaxLen;
            }
        }
        int minRemv = n;
        for (int i = 0; i < n; i++) {
            if (dp1[i] > 1 && dp2[i] > 1) { // valid mountain peak
                int mountainLen = dp1[i] + dp2[i] - 1;
                minRemv = Math.min(minRemv, n - mountainLen);
            }
        }
        return minRemv;
    }
}
