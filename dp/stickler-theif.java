class Solution {
    int[] dp;

    /**
     * Stickler the thief wants to loot money from a society having n houses in a single line.
     * He is a weird person and follows a certain rule when looting the houses. According to the rule,
     * he will never loot two consecutive houses. At the same time, he wants to maximize the amount he loots.
     * The thief knows which house has what amount of money but is unable to come up with an optimal looting strategy.
     * He asks for your help to find the maximum money he can get if he strictly follows the rule.
     * ith house has a[i] amount of money present in it.
     * @param arr
     * @param n
     * @return
     */
    public int FindMaxSum(int arr[], int n) {
        dp = new int[n];
        return FindMaxSum(arr, 0, n);
    }
    
    public int FindMaxSum(int arr[], int i, int n) {
        if(i >= n) return 0;
        if(dp[i] != 0) return dp[i];
        
        int inc = arr[i] + FindMaxSum(arr, i+2, n);
        int exc = FindMaxSum(arr, i+1, n);
        dp[i] = Math.max(inc, exc);
        return dp[i];
    }
}
