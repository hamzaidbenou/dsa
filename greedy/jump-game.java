package greedy;

class Solution {

    /**
     * Given an positive integer N and a list of N integers A[].
     * Each element in the array denotes the maximum length of jump you can cover.
     * Find out if you can make it to the last index if you start at the first index of the list.
     * @param arr
     * @param n
     * @return
     */
    static int canReach(int[] arr, int n) {
        int prev=-1, far=arr[0], max=0;
        while(far < n-1) {
            for(int i=prev+1; i<=far; i++) max = Math.max(max, i+arr[i]);
            if(far >= max) return 0;
            prev = far;
            far = max;
        }
        return 1;
    }
}
