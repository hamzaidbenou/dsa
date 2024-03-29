package binary_search;

import java.util.Arrays;

class Solution {
    
    /**
     * Given an array of integers, find the length of the longest (strictly) increasing subsequence from the given array.
     * @param n
     * @param arr
     * @return
     */
    static int longestSubsequence(int n, int arr[]){
        int[] dp = new int[n];
	    Arrays.fill(dp, Integer.MAX_VALUE);
	    int j, len=0, ans=0;
	    
	    for(int i=0; i<n; i++){
	        j = search(0, len, arr[i], dp);
	        if(j >= len) dp[len++] = arr[i];
	        else dp[j] = arr[i];
	        ans = Math.max(ans, len);
	    }
	    
	    return len;
    }
    
    static int search(int l, int r, int t, int[] arr){
	    while(l <= r){
	        int mid = l + (r-l)/2;
	        if(t <= arr[mid]) r = mid-1;
	        else l = mid+1;
	    }
	    return r+1;
	}
} 