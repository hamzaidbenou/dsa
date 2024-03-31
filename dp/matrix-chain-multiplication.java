class Solution{

    /**
     * Given a sequence of matrices, find the most efficient way to multiply these matrices together.
     * The efficient way is the one that involves the least number of multiplications.
     * The dimensions of the matrices are given in an array arr[] of size N (such that N = number of matrices + 1) 
     * where the ith matrix has the dimensions (arr[i-1] x arr[i]).
     * @param n
     * @param arr
     * @return
     */
    public static int matrixMultiplication(int n, int arr[]){
        int[][] dp = new int[n][n];
        for(int len=2; len<n; len++){
            for(int i=0; (i+len)<n; i++) {
                int j = i+len, min=Integer.MAX_VALUE;
                for(int k=i+1; k<j; k++) {
                    min = Math.min(min, dp[i][k]+dp[k][j]+arr[i]*arr[k]*arr[j]);
                }
                dp[i][j] = min;
            }
        }
        return dp[0][n-1];
    }
}