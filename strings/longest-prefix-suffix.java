package strings;

class Solution {

    /**
     * Given a string of characters, find the length of the longest proper prefix which is also a proper suffix.
     * NOTE: Prefix and suffix can be overlapping but they should not be equal to the entire string.
     * @param s
     * @return
     */
    public int lps(String s) {
        int n=s.length(), len=0, i=1;
        // dp[i] is the lps of s[0,i]
        int[] dp = new int[n];
        while(i<n) {
            if(s.charAt(i) == s.charAt(len)) dp[i++] = ++len;
            else {
                // [---[len new value]****---][len]....[---****---][i]
                if(len != 0) len=dp[len-1];
                else dp[i++]=0;
            }
        }
        return dp[n-1];
    }
}