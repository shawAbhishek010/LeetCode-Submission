class Solution {
    public int numTrees(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        int ans = helper(n,dp);
        
        return ans;
    }
    public int helper(int n,int dp[]) {
        if (n <= 1)
            return 1;
            if(dp[n]!=-1)return dp[n];
        int ans = 0;
        for (int root = 1; root <= n; root++) {
            int left = helper(root - 1,dp);
            int right = helper(n - root,dp);
            ans += left * right;
            dp[n]=ans;
        }
        return dp[n];
    }

}

// public class Solution {
//     public int numTrees(int n) {
//         int[] dp = new int[n + 1];
//         dp[0] = 1;
//         for (int i = 1; i <= n; i++) {
//             for (int j = 1; j <= i; j++) {
//                 dp[i] += dp[j - 1]*dp[i - j];
//             }
//         }
//         return dp[n];
//     }
// }