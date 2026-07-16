class Solution {
    public long gcdSum(int[] nums) {
        int max = nums[0];
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
            nums[i] = gcd(nums[i], max);
        }
        Arrays.sort(nums);
        int i = 0;
        int j = n - 1;
        long ans = 0;
        while (i < j) {
            int val = gcd(nums[i], nums[j]);
            ans += val;
            i++;
            j--;
        }
        return ans;
    }

    public int gcd(int a, int b) {
        while (b % a != 0) {
            int val = b % a;
            b = a;
            a = val;
        }
        return a;
    }
}