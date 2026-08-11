class Solution {
    int count = Integer.MIN_VALUE;
    public int maximumRequests(int n, int[][] requests) {
        int[] arr = new int[n];
        backTrack(n, requests, 0, arr, 0);
        return count;
    }

    public void backTrack(int n, int[][] requests,int idx, int[] arr, int picked) {
        // BASE CASE
        if (idx == requests.length) {
            // check whether all buildings are balanced
            for (int i = 0; i < n; i++) {
                if (arr[i] != 0)
                    return;
            }

            count = Math.max(count, picked);
            return;
        }

        int x = requests[idx][0];
        int y = requests[idx][1];
        //pick
        arr[x] -= 1;
        arr[y] += 1;

        backTrack(n, requests, idx + 1, arr, picked + 1);

        // BACKTRACK
        arr[x] += 1;
        arr[y] -= 1;
        //skip
        backTrack(n, requests, idx + 1, arr, picked);
    }
}