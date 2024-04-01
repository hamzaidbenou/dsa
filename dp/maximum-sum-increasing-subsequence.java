class Solution {

    /**
     * Given an array of n positive integers. Find the sum of the maximum sum subsequence of the given array such that 
     * the integers in the subsequence are sorted in strictly increasing order i.e. a strictly increasing subsequence. 
     * @param arr
     * @param n
     * @return
     */
	public int maxSumIS(int arr[], int n){  
	    int[] dp = new int[n];
	    int ans=0, max_sum;
	    
	    for(int i=0; i<n; i++) {
	        max_sum=arr[i];
	        for(int j=i-1; j>=0; j--){
	            if(arr[i] > arr[j]) max_sum=Math.max(max_sum, dp[j]+arr[i]);
	        }
	        dp[i] = max_sum;
	        ans = Math.max(dp[i], ans);
	    }
	    return ans;
	}
}