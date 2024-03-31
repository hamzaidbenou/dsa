package sorting;

import java.util.Arrays;

class Solution {
    
    /**
     * Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order.
     * Merge them in sorted order without using any extra space. Modify arr1 so that it contains 
     * the first N elements and modify arr2 so that it contains the last M elements.
     * @param arr1
     * @param arr2
     * @param n
     * @param m
     */
    public static void merge(long arr1[], long arr2[], int n, int m) {
        int l=0, r=n;
        long max = (long)(1e9 + 7), min = -1L, tmp;
        while(l<=r){
            int leftSize = l+(r-l)/2, rightSize=n-leftSize;
            
            long ll = (leftSize > 0) ? arr1[leftSize-1] : min;
            long rl = (leftSize < n) ? arr1[leftSize] : max;
            
            long lr = (rightSize > 0 && rightSize <= m) ? arr2[rightSize-1] : ((rightSize <= 0) ? min : max);
            long rr = (rightSize >= 0 && rightSize < m) ? arr2[rightSize] : ((rightSize < 0) ? min : max);
            //System.out.println(left + "  => "+ right);
            if(ll <= rr && lr <= rl){
                for(int i=0; i<rightSize; i++){
                    tmp = arr2[i];
                    arr2[i] = arr1[leftSize+i];
                    arr1[leftSize+i] = tmp;
                }
                Arrays.sort(arr1);
                Arrays.sort(arr2);
                return;
            } else {
                if(ll > rr) r=leftSize-1;
                else l=leftSize+1;
            }
        }
    }
}
