class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        helper(nums,n,arr,ans);
        return ans;
    }
    public void helper(int[] nums,int n,List<Integer> arr,List<List<Integer>> ans){
        //base cond
        if(arr.size()==n){
            ans.add(new ArrayList<>(arr));
            return;
        }
        for(int i = 0;i<n;i++){
            if(arr.contains(nums[i])) continue;
            arr.add(nums[i]);
            //explore
            helper(nums,n,arr,ans);
            arr.remove(arr.size()-1);
        }
    }
}