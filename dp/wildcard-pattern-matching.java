class Solution {
    int[][] dp; //1:false, 2:true

    /**
     * Given two strings 'str' and a wildcard pattern 'pattern' of length N and M respectively,
     * You have to print '1' if the wildcard pattern is matched with str else print '0'.
     * The wildcard pattern can include the characters ‘?’ and ‘*’
     * ‘?’ – matches any single character
     * ‘*’ – Matches any sequence of characters (including the empty sequence)
     * @param pattern
     * @param str
     * @return
     */
    public int wildCard(String pattern, String str){
        int n=str.length(), m=pattern.length();
        dp = new int[n][m];
        boolean ans = lcs(str, pattern, 0, 0, n, m);
        return ans ? 1 : 0;
    }
    
    public boolean lcs(String s, String p, int i, int j, int n, int m){
        if(i>=n && j>=m) return true;
        if(i<n && j>=m) return false;
        if(i>=n && j<m) {
            for(int k=j; k<m; k++) if(p.charAt(k) != '*') return false;
            return true;
        }
        
        if(dp[i][j] != 0) return dp[i][j]==2;
        boolean ans = false;
        
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?') ans=lcs(s, p, i+1, j+1, n, m);
        else {
            if(p.charAt(j) == '*'){
                ans = lcs(s, p, i+1, j+1, n, m) || lcs(s, p, i+1, j, n, m) || lcs(s, p, i, j+1, n, m);
            }
        }
        dp[i][j] = ans ? 2 : 1;
        return ans;
    }
}