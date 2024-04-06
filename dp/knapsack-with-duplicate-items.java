import java.util.Arrays;

class Solution {
    static int[][] dp;

    /**
     * Given a set of N items, each with a weight and a value, represented by the array w and val respectively.
     * Also, a knapsack with weight limit W.
     * The task is to fill the knapsack in such a way that we can get the maximum profit. Return the maximum profit.
     * @param n
     * @param w
     * @param val
     * @param wt
     * @return
     */
    static int knapSack(int n, int w, int val[], int wt[]){
        dp = new int[n][w+1];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        
        return knapSack(0, 0, n, w, val, wt);
    }
    
    static int knapSack(int i, int w, int n, int max, int val[], int wt[]){
        if(i >= n || w==max) return 0;
        if(dp[i][w] != -1) return dp[i][w];
        
        int inc_dup=-1, inc=-1;
        if(w+wt[i] <= max) {
            inc_dup = val[i] + knapSack(i, w+wt[i], n, max, val, wt);
            inc = val[i] + knapSack(i+1, w+wt[i], n, max, val, wt);
        }
        int exc = knapSack(i+1, w, n, max, val, wt);
        
        dp[i][w] = Math.max(exc, Math.max(inc_dup, inc));
        return dp[i][w];
    }
}
