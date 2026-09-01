class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        ArrayList <Integer> arr;
        for (int i = 0; i < n - 2; i++) {
           if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = n - 1;
            while (k > j) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    arr = new ArrayList<>();
                    arr.add(nums[i]);
                    arr.add(nums[j]);
                    arr.add(nums[k]);
                    ans.add(arr);
                    k--;
                    j++;
                while (k>j && nums[j] == nums[j - 1])
                        j++;
                while (k>j && nums[k] == nums[k + 1])
                        k--;
                }
                else if(sum>0) k--;
                else j++;
                
            } 
        }
        return ans;
    }
}
