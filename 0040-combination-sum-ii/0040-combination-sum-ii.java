// GAVE ME TLE ERROR AS I FIRST GENERATE ALL POSSIBLE SLOUTIONS THEN NOT ADDING INTO FINAL ONE 

// class Solution {
//     public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//          Set<List<Integer>> ans = new LinkedHashSet<>();
//         List<Integer> arr = new ArrayList<>();
//         Arrays.sort(candidates);
//         helper(0,candidates,target,arr,ans);
//         List<List<Integer>> result = new ArrayList<>();
//         for (List<Integer> array : ans) {
//             result.add(array);
//         }
//         return result;
//     }
//     public void helper(int idx,int[] candidates,int target,List<Integer> arr, Set<List<Integer>> ans){
//         //base condn
//         if(target==0){
//             ans.add(new ArrayList<>(arr));
//             return;
//         }
//         if (0 > target) return;
//         if(idx==candidates.length) return;
//         arr.add(candidates[idx]);
//         target-=candidates[idx];
//         helper(idx+1,candidates,target,arr,ans);
//         //backtrack
//         arr.remove(arr.size()-1);
//         target+=candidates[idx];
//         //skip
//         helper(idx+1,candidates,target,arr,ans);
//     }
// }

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0, candidates, target, arr, ans);
        return ans;
    }

    public void helper(int idx, int[] candidates, int target,List<Integer> arr, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(arr));
            return;
        }
        if (target < 0 || idx == candidates.length) return;
           
        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1])
                continue;

            if (candidates[i] > target)
                break;

            arr.add(candidates[i]);
            helper(i + 1, candidates, target - candidates[i], arr, ans);
            arr.remove(arr.size() - 1);
        }
    }
}