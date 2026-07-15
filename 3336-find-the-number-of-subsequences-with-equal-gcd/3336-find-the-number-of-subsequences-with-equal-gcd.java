// class Solution {
//     int mod = 1000000007;

//     public int subsequencePairCount(int[] nums) {
//         int n = nums.length;
//         int max = 0;
//         for (int ele : nums) {
//             max = Math.max(max, ele);
//         }

//         int[][][] dp = new int[n + 1][max + 1][max + 1];
//         for (int[][] matrix : dp) {
//             for (int[] row : matrix) {
//                 Arrays.fill(row, -1);
//             }
//         }
//         int ans = solve(nums, 0, 0, 0,dp);//idx,GCD of seq1 and seq2
//         return ans;
//     }

//     public int solve(int nums[], int idx, int first, int second, int dp[][][]) {
//         //Base condn
//         if (idx == nums.length) {
//             if (first != 0 && second != 0) {
//                 if (first == second)
//                     return 1;
//                 else
//                     return 0;
//             } else
//                 return 0;
//         }
//         if(dp[idx][first][second]!=-1)return dp[idx][first][second];
//         int skip = solve(nums, idx + 1, first, second,dp) % mod;
//         int pick1 = solve(nums, idx + 1, gcd(first, nums[idx]), second,dp) % mod;
//         int pick2 = solve(nums, idx + 1, first, gcd(second, nums[idx]),dp) % mod;
//         return dp[idx][first][second]=(skip + pick1 + pick2) % mod;
//     }

//     public int gcd(int a, int b) {
//         if (a == 0) {
//             return b;
//         }

//         if (b == 0) {
//             return a;
//         }
//          while(b%a!=0){
//             int val = b%a;
//             b = a;
//             a = val;
//         }
//         return a;

//     }
// }



class Solution {
    int mod = 1_000_000_007;

    private int gcd(int a, int b) {
          if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
         while(b%a!=0){
            int val = b%a;
            b = a;
            a = val;
        }
        return a;

    }

    public int subsequencePairCount(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int ele : nums) {
            max = Math.max(max, ele);
        }

        int[][][] dp = new int[n + 1][max + 1][max + 1];
        // Base case
        for (int first = 0; first <= max; first++) {
            for (int second = 0; second <= max; second++) {
                boolean bothNonEmpty = (first != 0 && second != 0);
                boolean gcdsMatch    = (first == second);
                dp[n][first][second] = (bothNonEmpty && gcdsMatch) ? 1 : 0;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int first = max; first >= 0; first--) {
                for (int second = max; second >= 0; second--) {

                    // Skip this index entirely
                    int skip  = dp[i + 1][first][second] % mod; //solve(i+1, first, second);

                    // Include this index in seq1
                    int take1 = dp[i + 1][gcd(first, nums[i])][second] % mod;

                    // Include this index in seq2
                    int take2 = dp[i + 1][first][gcd(second, nums[i])] % mod;

                    dp[i][first][second] = (int)((0L +skip + take1 + take2) % mod);
                }
            }
        }

        return dp[0][0][0]; //return solve(nums, 0, 0, 0);
    }
}