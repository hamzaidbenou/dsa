package sorting;

import java.util.Arrays;

class Solution {

    /**
     * Given an array Arr of N positive integers and an integer K, find K largest elements from the array.
     * The output elements should be printed in decreasing order.
     * @param arr
     * @param n
     * @param k
     * @return
     */
    int[] kLargest(int[] arr, int n, int k) {
        int j=0, kth = partition(arr, 0, n-1, n-k);
        //System.out.println(kth);
        int[] ans = new int[k];
        for(int i=0; i<n; i++) if(arr[i] > kth) ans[j++]=arr[i];
        while(j<k) ans[j++]=kth;
        Arrays.sort(ans);
        for(int i=0; i<k/2; i++){
            j = ans[i];
            ans[i] = ans[k-i-1];
            ans[k-i-1] = j;
        }
        
        return ans;
    }
    
    int partition(int arr[], int low, int high, int rg){
        int tmp, lo=low, pivot=arr[high];
        for(int i=low; i<high; i++){
            if(pivot > arr[i]) {
                tmp = arr[lo];
                arr[lo++] = arr[i];
                arr[i] = tmp;
            }
        }
        tmp = arr[lo];
        arr[lo] = arr[high];
        arr[high] = tmp;
        
        if(rg == lo) return arr[rg];
        if(rg < lo) return partition(arr, low, lo-1, rg);
        return partition(arr, lo+1, high, rg);
    }
}
