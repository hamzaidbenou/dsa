package arrays;

class Solution {

    /**
     * Given a boolean 2D array of n x m dimensions, consisting of only 1's and 0's, where each row is sorted.
     * Find the 0-based index of the first row that has the maximum number of 1's.
     * @param arr
     * @param n
     * @param m
     * @return
     */
    int rowWithMax1s(int arr[][], int n, int m) {
        int ans=0, start=0;
        while(start<m && arr[0][start]==0) start++;
        if(start == 0) return ans;
        
        for(int i=1; i<n; i++){
            while(start>0 && arr[i][start-1] == 1) {
                start--;
                ans = i;
            }
            if(start == 0) return ans;
        }
        return (start == m) ? -1 : ans;
    }
}
