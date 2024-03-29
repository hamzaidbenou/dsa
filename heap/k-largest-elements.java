package heap;

import java.util.PriorityQueue;

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
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            if(pq.size() < k) pq.offer(arr[i]);
            else {
                if(arr[i] > pq.peek()){
                    pq.poll();
                    pq.offer(arr[i]);
                }
            }
        }
        int[] ans = new int[k];
        for(int i=k-1; i>=0; i--) ans[i]=pq.poll();
        
        return ans;
    }
}
