// class Solution {
//     public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
//         int k = k1 + k2;
//         int n = nums1.length;
//         int ans = 0;
//         PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//         for (int i = 0; i < n; i++) {
//             int result = Math.abs(nums1[i] - nums2[i]);
//             pq.offer(result);
//         }
//        while (k > 0) {
//             int top = pq.poll();
//             if (top == 0) {
//                 pq.offer(top);
//                 break;
//             }
//             top = top - 1;
//             pq.offer(top);
//             k--;
//         }

//         while (!pq.isEmpty()) {
//             int top = pq.poll();
//             ans += (long) top * top;
//         }

//         return ans;
//     }
// }

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int k = k1 + k2;
        int n = nums1.length;
        int ans[] = new int[100001];
        for (int i = 0; i < n; i++) {
            int result = Math.abs(nums1[i] - nums2[i]);
            ans[result]++;
        }
        int operation = k;
        int len = ans.length;
        for (int i = len - 1; i >= 0 && operation > 0; i--) {
            if (ans[i] == 0) continue;
            int currentOperation = Math.min(operation,ans[i]);
            ans[i]= ans[i]-currentOperation;
            /***********************************/
            if(i>0) ans[i - 1] =ans[i - 1] + currentOperation;
            /*********************************/
            operation-=currentOperation;
        }
        long minSum = 0;
        for(int i =0;i<len;i++){
            minSum = minSum + 1L * i * i * ans[i];
        }
        return minSum;
    }
}