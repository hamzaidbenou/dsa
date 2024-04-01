package sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    static Map<Integer, Integer> order;
    /**
     * Sort an array according to the other array.
     * @param A1
     * @param N
     * @param A2
     * @param M
     * @return
     */
    public static int[] sortA1ByA2(int A1[], int N, int A2[], int M){
        order = new HashMap<>();
        for(int i=0; i<M; i++)
            if(!order.containsKey(A2[i]))
                order.put(A2[i], i);
        mergeSort(A1, 0, N-1);
        return A1;
    }
    public static boolean smallerThan(int a, int b){
        if(!order.containsKey(a) && !order.containsKey(b)) return a <= b;
        if(!order.containsKey(b)) return true;
        if(!order.containsKey(a)) return false;
        return order.get(a) <= order.get(b);
    }

    public static void mergeSort(int[] arr, int l, int r){
        if(l < r){
            int mid = l+(r-l)/2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, r);
            mergeAndSort(arr, l, mid, r);
        }
    }

    public static void mergeAndSort(int[] arr, int l, int m, int r){
        int[] left = Arrays.copyOfRange(arr, l, m+1);
        int[] right = Arrays.copyOfRange(arr, m+1, r+1);
        int i=0, j=0, k=l;
        
        while(i<left.length && j<right.length){
            if(smallerThan(left[i], right[j])) arr[k++]=left[i++];
            else arr[k++]=right[j++];
        }
        
        while(i<left.length) arr[k++]=left[i++];
        while(j<right.length) arr[k++]=right[j++];
    }
}
