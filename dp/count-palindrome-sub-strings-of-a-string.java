class Solution {

    /**
     * Given a string, the task is to count all palindromic sub-strings present in it.
     * Length of palindrome sub-string must be greater than or equal to 2. 
     * @param S
     * @param N
     * @return
     */
    public int CountPS(String S, int N){
        boolean[][] dp = new boolean[N][N];
        int cnt=0, j;
        for(int len=1; len<=N; len++){
            for(int i=0; len+i-1<N; i++){
                j = len+i-1;
                if(len == 1) dp[i][j] = true;
                else {
                    if(S.charAt(i)==S.charAt(j)) dp[i][j]= (i+1 > j-1) || dp[i+1][j-1];
                    if(dp[i][j]) cnt++;
                }
            }
        }
        return cnt;
    }
}