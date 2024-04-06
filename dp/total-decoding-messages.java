import java.util.Arrays;

class Solution {
    int mod = (int)(1e9 +7);
    long[] dp;

    /**
     * A top secret message containing letters from A-Z is being encoded to numbers using the following mapping:
     * 'A' -> 1, 'B' -> 2, ..., 'Z' -> 26
     * You are an FBI agent. You have to determine the total number of ways that message can be decoded, 
     * as the answer can be large return the answer modulo 109 + 7.
     * Note: An empty digit sequence is considered to have one decoding. It may be assumed that the input 
     * contains valid digits from 0 to 9 and If there are leading 0s, extra trailing 0s and two or more 
     * consecutive 0s then it is an invalid string.
     * @param str
     * @return
     */
    public int CountWays(String str){
       int n=str.length();
       dp = new long[n];
       Arrays.fill(dp, -1L);
       return (int)(CountWays(str, 0, n)%mod);
    }
    
    public long CountWays(String s, int i, int n){
        if(i>=n) return 1L;
        if(dp[i] != -1) return dp[i];
        
        int curr = s.charAt(i)-'0';
        if(curr == 0) return 0;
        if(i == n-1) return 1L;
        
        int next = s.charAt(i+1)-'0';
        
        dp[i] = CountWays(s, i+1, n)%mod;
        if(curr == 1 || (curr == 2 && next < 7)) dp[i] = (dp[i]+CountWays(s, i+2, n)%mod)%mod;
        return dp[i];
    }
}