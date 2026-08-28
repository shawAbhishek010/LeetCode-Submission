class Solution {
    public int missingMultiple(int[] nums, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int ele : nums) {
            arr.add(ele);
        }
        int n = arr.size();
        int mul = 1;
        for (int i = 1; i <= n; i++) {
            mul = k * i;
            if (!arr.contains(mul))
                return mul;
        }
        return k*(n+1);
    }
}