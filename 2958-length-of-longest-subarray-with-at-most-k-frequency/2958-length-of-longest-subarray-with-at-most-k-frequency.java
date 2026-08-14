class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int n = nums.length;
        int maxLen = 0;

        while (j < n) {
            int num = nums[j];
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                int val = map.get(num);
                map.put(num, val + 1);

                while (map.get(num) > k) {

                    int left = nums[i];
                    int leftVal = map.get(left);

                    map.put(left, leftVal - 1);

                    i++;
                }
            }
            maxLen = Math.max(maxLen, j - i + 1);

            j++;
        }
        return maxLen;
    }
}