class Solution {
    Integer[][] dp;
    int ending_state;
    
    /**
     * Given a matrix cost of size n where cost[i][j] denotes the cost of moving from city i to city j.
     * Your task is to complete a tour from the city 0 (0 based index) to all other cities such that you 
     * visit each city exactly once and then at the end come back to city 0 in min cost.
     * @param cost
     * @return
     */
    public int total_cost(int[][] cost){
        int n = cost.length;
        ending_state = (1<<n) - 1;
        dp = new Integer[ending_state + 1][n];
        return total_cost(cost, n, 0, 1);
    }
    
    public int total_cost(int[][] cost, int n, int i, int mask){
        if(mask == ending_state) return cost[i][0];
        if(dp[mask][i] != null) return dp[mask][i];
        
        int ans = Integer.MAX_VALUE;
        for(int j=0; j<n; j++){
            if(j == i || ((mask >> j)&1) == 1) continue;
            ans = Math.min(ans, cost[i][j] + total_cost(cost, n, j, (mask^(1<<j))));
        }
        dp[mask][i] = ans;
        return ans;
    }
}