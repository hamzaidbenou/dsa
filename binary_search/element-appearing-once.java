package binary_search;

class Solution {

    /**
     * Given a sorted array A[] of N positive integers having all the numbers occurring exactly twice,
     * except for one number which will occur only once. Find the number occurring only once.
     * @param arr
     * @param n
     * @return
     */
    public static int search(int[] arr, int n){
        int l=0, r=n-1;
        while(l <= r){
            int mid = l+(r-l)/2;
            if(mid+1 < n && arr[mid]==arr[mid+1]) {
                if((r-mid-1)%2 == 0) r=mid-1;
                else l=mid+2;
            } else {
                if(mid-1 >= 0 && arr[mid]==arr[mid-1]){
                    if((mid-l-1)%2 == 0) l=mid+1;
                    else r=mid-2;
                } else {
                    return arr[mid];
                }
            }
        }
        return l<n ? arr[l] : arr[r];
    }
}
