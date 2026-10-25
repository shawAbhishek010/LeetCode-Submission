
class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int posCount = 0;
        int negCount = 0;
        //for negative count 
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < 0) {
                negCount = Math.max(negCount, mid + 1);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        low = 0 ;
        high = n-1;
         //for positive count 
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > 0) {
                posCount = Math.max(posCount,n- mid);
                high = mid - 1;
            } else {
               low = mid + 1;
            }
        }

        return Math.max(posCount,negCount);
    }
}
