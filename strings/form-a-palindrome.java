package strings;

import java.util.Arrays;

class Solution {
    static int[][] dp;

    /**
     * Given a string, find the minimum number of characters to be inserted to convert it to palindrome.
     * For Example:
     * ab: Number of insertions required is 1. bab or aba
     * aa: Number of insertions required is 0. aa
     * abcd: Number of insertions required is 3. dcbabcd
     * @param str
     * @return
     */
    static int countMin(String str) {
        int n = str.length();
        dp = new int[n+1][n+1];
        for(int i=0; i<=n; i++)
            Arrays.fill(dp[i], -1);
        return countMin(str, 0, n-1, n);
    }
    
    static int countMin(String str, int i, int j, int n) {
        if(i>=n || j>=n) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int aux = countMin(str, i+1, j-1, n);
        if(str.charAt(i)==str.charAt(j))
            dp[i][j] = aux;
        else
            dp[i][j] = Math.min(Math.min(countMin(str,i+1,j,n), countMin(str,i,j-1,n)), aux+1) + 1;
        
        return dp[i][j];
    }
}
