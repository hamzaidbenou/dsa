class Solution {
    long[][] dp;
    /**
     * Given an integer array coins[ ] of size N representing different denominations of currency and an 
     * integer sum, find the number of ways you can make sum by using different combinations from coins[].  
     * @param coins
     * @param N
     * @param sum
     * @return
     */
    public long count(int coins[], int N, int sum) {
        dp = new long[N][sum+1];
        for(int i=0; i<N; i++){
            for(int j=0; j<=sum; j++){
                dp[i][j] = -1L;
            }
        }
        return count_help(coins, N, 0, 0, sum);
    }
    
    public long count_help(int coins[], int n, int i, int running_sum, int sum) {
        if(i >= n || running_sum > sum) return 0L;
        if(running_sum == sum) return 1L;
        if(dp[i][running_sum] != -1L) return dp[i][running_sum];
        
        long cnt= count_help(coins, n, i, running_sum+coins[i], sum);
        cnt += count_help(coins, n, i+1, running_sum, sum);
        
        dp[i][running_sum] = cnt;
        return cnt;
    }
}