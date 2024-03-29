class Solution{

    static Boolean[][] dp;
    
    /**
     * Given an array of non-negative integers, and a value sum, determine if there is a subset 
        of the given set with sum equal to given sum. 
     * @param N
     * @param arr
     * @param sum
     */
    static Boolean isSubsetSum(int N, int arr[], int sum){
        dp = new Boolean[N][sum+1];
        return knapsack(N, arr, sum, 0, 0);
    }
    
    static Boolean knapsack(int n, int[] arr, int sum, int i, int running_sum){
        if(running_sum == sum) return true;
        if(i >= n || running_sum > sum) return false;
        if(dp[i][running_sum] != null) return dp[i][running_sum];
        
        boolean include = knapsack(n, arr, sum, i+1, running_sum+arr[i]);
        boolean exclude = knapsack(n, arr, sum, i+1, running_sum);
        
        dp[i][running_sum] = include || exclude;
        return dp[i][running_sum];
    }
}