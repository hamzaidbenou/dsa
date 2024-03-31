package arrays;

class Solution {
    static int ans;

    /**
     * Given an array arr[] of N elements. Find the number of non-empty subsets whose product of 
     * elements is less than or equal to a given integer K.
     * @param arr
     * @param n
     * @param k
     * @return
     */
    static int numOfSubsets(int[] arr, int n, int k) {
        ans = 0;
        help(arr, n, k, 0, 1);
        return ans;
    }
    
    static void help(int[] arr, int n, int k, int i, int product) {
        if(i >= n || product>k) return;
        
        if(product*arr[i] <= k) ans++;
        help(arr, n, k, i+1, product*arr[i]);
        help(arr, n, k, i+1, product);
    }
}
