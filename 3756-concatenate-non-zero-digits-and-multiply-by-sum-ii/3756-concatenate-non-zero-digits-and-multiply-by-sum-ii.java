class Solution {
    static final long MOD = 1_000_000_007;
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        int[] nonZeroCount = new int[n];
        long[] numberUpto = new long[n];
        long[] digitSum = new long[n];
        long[] power = new long[n + 1];

        power[0] = 1;
        for (int i = 1; i <= n; i++) {
            power[i] = (power[i - 1] * 10) % MOD;
        }

        for (int i = 0; i < n; i++) {
            int digit = s.charAt(i) - '0';
            if (i == 0) {
                nonZeroCount[i] = (digit == 0) ? 0 : 1;
                numberUpto[i] = digit;
                digitSum[i] = digit;
            } else {
                nonZeroCount[i] = nonZeroCount[i - 1];
                digitSum[i] = digitSum[i - 1] + digit;
                if (digit != 0) {
                    nonZeroCount[i]++;
                    numberUpto[i] = (numberUpto[i - 1] * 10 + digit) % MOD;
                } else {
                    numberUpto[i] = numberUpto[i - 1];
                }
            }
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1];

            int beforeCount = (l == 0) ? 0 : nonZeroCount[l - 1];
            int totalCount = nonZeroCount[r];
            int len = totalCount - beforeCount;

            if (len == 0) {
                ans[i] = 0;
                continue;
            }

            long beforeNumber = (l == 0) ? 0 : numberUpto[l - 1];

            long x = (numberUpto[r] - (beforeNumber * power[len]) % MOD + MOD) % MOD;
            long sum = digitSum[r] - (l == 0 ? 0 : digitSum[l - 1]);

            ans[i] = (int) ((x * sum) % MOD);
        }

        return ans;
    }
}