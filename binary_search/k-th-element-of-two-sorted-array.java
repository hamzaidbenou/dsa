package binary_search;


class Solution {

    /**
     * Given two sorted arrays arr1 and arr2 of size N and M respectively and an element K.
     * The task is to find the element that would be at the kth position of the final sorted array.
     * @param arr1
     * @param arr2
     * @param n
     * @param m
     * @param k
     * @return
     */
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        if(n > m) return kthElement(arr2, arr1, m, n, k);
        int max=Integer.MAX_VALUE, min=Integer.MIN_VALUE;
        int mid, arr1_left, arr1_right, arr2_left, arr2_right, l=0, r=k-1;
        long ans = 0L;
        while(l <= r) {
            mid = l+(r-l)/2;
            arr1_left = mid < n ? arr1[mid] : max;
            arr1_right = mid+1 < n ? arr1[mid+1] : max;
            arr2_left = k-mid-2 >= 0 ? (k-mid-2 < m ? arr2[k-mid-2] : max) : min;
            arr2_right = k-mid-1 >= 0 ? (k-mid-1 < m ? arr2[k-mid-1] : max) : min;
            ans = 1L*Math.max(arr2_left, arr1_left);
            if(arr2_left <= arr1_right && arr1_left <= arr2_right) return ans;
            else {
                if(arr2_left > arr1_right) l = mid+1;
                else r = mid-1;
            }
        }
        if(r < 0) return 1L*arr2[k-1];
        return ans;
    }
}