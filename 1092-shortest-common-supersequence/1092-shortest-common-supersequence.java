class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        StringBuilder a = new StringBuilder(str1);
        StringBuilder b = new StringBuilder(str2);
        int m = a.length();
        int n = b.length();
        //same code of LCS
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        //Print Logic for LCS.........
        StringBuilder ans = new StringBuilder();
        int i = m;
        int j = n;
        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                ans.insert(0, a.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else
                j--;
        }
        System.out.println(ans);//LCS
        i = 0;
        j = 0;
        int k = 0;//traverse on LCS
        StringBuilder result = new StringBuilder();
        while (i < m && j < n && k < ans.length()) {

            while (a.charAt(i) != ans.charAt(k)) {
                result.append(a.charAt(i));
                i++;
            }

            while (b.charAt(j) != ans.charAt(k)) {
                result.append(b.charAt(j));
                j++;
            }

            result.append(ans.charAt(k));
            i++;
            j++;
            k++; // <-- Missing
        }
        // Append remaining characters
        while (i < m) {
            result.append(a.charAt(i++));
        }

        while (j < n) {
            result.append(b.charAt(j++));
        }
        return result.toString();
    }

}