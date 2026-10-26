// class Solution {
//     public void sortColors(int[] nums) {
//         Arrays.sort(nums);
//     }
// }

class Solution {
    public void sortColors(int[] arr) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int mid = 0;
        while (mid<=high) {
            if (arr[mid] == 2) {
                swap(mid, high,arr);
                high--;
            }
           else if (arr[mid] == 1)
                mid++;
            else  {             // (arr[mid] == 0)
                swap(mid, low,arr);
                low++;
                mid++;
            }
        }
    }
    public void swap(int i, int j, int [] arr){
        int temp = arr[i];
        arr[i] = arr[j];
       arr[j] = temp;
    }
}