package binary_search;

class Solution {

    /**
     * Dilpreet wants to paint his dog's home that has n boards with different lengths.
     * The length of ith board is given by arr[i] where arr[] is an array of n integers.
     * He hired k painters for this work and each painter takes 1 unit time to paint 1 unit of the board.
     * The problem is to find the minimum time to get this job done if all painters start together with 
     * the constraint that any painter will only paint continuous boards, say boards numbered {2,3,4} or 
     * only board {1} or nothing but not boards {2,4,5}.
     * @param arr
     * @param n
     * @param k
     * @return
     */
    static long minTime(int[] arr, int n, int k){
        long lo=0L, hi=0L;
        for(int i : arr) {
            lo = Math.max(lo, i*1L);
            hi += i;
        }
        while(lo <= hi) {
            long mid = lo + (hi-lo)/2;
            long cnt=1L, sum=0L;
            for(int i : arr) {
                sum += i;
                if(sum > mid) {
                    cnt++;
                    sum = i;
                }
            }
            if(cnt <= k) hi=mid-1;
            else lo=mid+1;
        }
        return hi+1;
    }
}
