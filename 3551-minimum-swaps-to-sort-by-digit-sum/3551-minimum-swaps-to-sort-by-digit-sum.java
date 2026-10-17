class Solution {
    class Pair implements Comparable<Pair> {
        int org;
        int sum;
        int indx;

        Pair(int org, int sum, int indx) {
            this.org = org;
            this.sum = sum;
            this.indx = indx;
        }

        public int compareTo(Pair p) {
            if (this.sum != p.sum) {
                return this.sum - p.sum;
            }
            return this.org - p.org;
        }
    }

    public int minSwaps(int[] nums) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = digitSum(nums[i]);
            pq.add(new Pair(nums[i], sum, i));
        }
        int n = nums.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            Pair top = pq.remove();
            arr[i] = top.indx;
        }
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] == true || arr[i] == i) continue;
            int size = 0;
            int j = i;

            while (visited[j] == false) {
                visited[j] = true;
                j = arr[j];
                size++;
            }

            count =  count +size - 1;
        }
        return count;
    }

    public int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            int val = num % 10;
            sum += val;
            num /= 10;
        }
        return sum;
    }
}
