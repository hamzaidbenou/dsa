class Solution {

    /**
     * Given a string S consisting only of opening and closing parenthesis 'ie '('  and ')', find out the 
     * length of the longest valid(well-formed) parentheses substring. NOTE: Length of the smallest valid substring ( ) is 2.
     * @param s
     * @return
     */
    static int findMaxLen(String s) {
        int n=s.length(), max=0;
        int[] dp = new int[n+1];
        for(int i=1; i<n; i++){
            if(s.charAt(i) == ')'){
                if(s.charAt(i-1) == '('){
                    dp[i] = 2 + ((i-2 >= 0) ? dp[i-2] : 0);
                } else {
                    if(i-dp[i-1]-1 >= 0 && s.charAt(i-dp[i-1]-1) == '(') {
                        dp[i] = 2 + dp[i-1];
                        if(i-dp[i-1]-2 >= 0) dp[i] += dp[i-dp[i-1]-2];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
