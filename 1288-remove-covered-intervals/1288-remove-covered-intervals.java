class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0])
                return Integer.compare(b[1], a[1]); // larger end first
            return Integer.compare(a[0], b[0]);
        });
        int n = intervals.length;
        int prevA = intervals[0][0];
        int prevB = intervals[0][1];
        int count = 1;
        ;
        for (int i = 1; i < n; i++) {
            int c = intervals[i][0];
            int d = intervals[i][1];
            int a = prevA;
            int b = prevB;
            if (c >= a && b >= d) {
                continue;
            } else {
                count++;
                prevA = c;
                prevB = d;
            }
        }
        return count;
    }
}
