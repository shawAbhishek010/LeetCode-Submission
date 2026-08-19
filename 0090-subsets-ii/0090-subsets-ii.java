class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
         Arrays.sort(nums);
         List<List<Integer>> ans = new ArrayList<>();
          List<Integer> arr = new ArrayList<>();
          HashMap<Integer,Integer> map = new HashMap<>();
          for(int ele:nums){
            if(!map.containsKey(ele))map.put(ele,1);
            else{
                int val = map.get(ele);
                map.put(ele,val+1);
            }
          }
          helper(0,nums,arr,ans,map);
          return ans;
    }
    public void helper(int idx,int[] nums, List<Integer> arr, List<List<Integer>> ans,HashMap<Integer,Integer> map){
           //base condn
         if(idx==nums.length){
            if (!ans.contains(arr))
                ans.add(new ArrayList<>(arr));
            return;
        }   
            int val = map.get(nums[idx]);
            if(val==0)return;
            arr.add(nums[idx]);
            map.put(nums[idx],val-1);
            helper(idx+1,nums,arr,ans,map);
            arr.remove(arr.size()-1);
            map.put(nums[idx],val);
            helper(idx+1,nums,arr,ans,map);

    }
}














// class Solution {
//     public List<List<Integer>> subsetsWithDup(int[] nums) {
//          List<List<Integer>> ans = new ArrayList<>();
//           List<Integer> arr = new ArrayList<>();
//           HashMap<Integer,Integer> map = new HashMap<>();
//           for(int ele:nums){
//             if(!map.containsKey(ele))map.put(ele,1);
//             else{
//                 int val = map.get(ele);
//                 map.put(ele,val+1);
//             }
//           }
//           helper(0,nums,arr,ans,map);
//           return ans;
//     }
//     public void helper(int idx,int[] nums, List<Integer> arr, List<List<Integer>>,HashMap<Integer,Integer> map){
//         //base condn
//          for (int num : map.keySet()) {
//             int val = map.get(num);
//             // no occurrence remaining
//             if (val == 0)
//                 continue;
//             // PICK
//             arr.add(num);
//             map.put(num, val - 1);

//             helper(nums, arr, ans, map);

//             // BACKTRACK
//             arr.remove(arr.size() - 1);
//             map.put(num, val);
//         }
//     }
// }
//     }
// }


