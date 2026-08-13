class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans  = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        helper(0,candidates,target,ans,arr,0);
        return ans;
    }
    public void helper(int idx,int[] candidates,int target,List<List<Integer>> ans,List<Integer> arr,int sum){
        //base condn
        if(sum==target){
            ans.add(new ArrayList<>(arr));
            return;
        }
        if (sum > target) return;
        if(idx==candidates.length) return;
        //pick
        arr.add(candidates[idx]);
        //explore
        helper(idx,candidates,target,ans,arr,sum+candidates[idx]);
        //backtrack
        arr.remove(arr.size() - 1);
        //skip
        helper(idx+1,candidates,target,ans,arr,sum);

    }
}