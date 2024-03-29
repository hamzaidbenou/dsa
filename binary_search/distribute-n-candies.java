package binary_search;

class Solution {

    /**
     * Given N candies and K people. In the first turn, the first person gets 1 candy, the second gets 2 candies, 
     * and so on till K people. In the next turn, the first person gets K+1 candies, the second person gets K+2 
     * candies and so on. If the number of candies is less than the required number of candies at every turn, 
     * then the person receives the remaining number of candies. Find the total number of candies every person 
     * has at the end.
     * @param a
     * @param b
     * @return
     */
    static Long[] distributeCandies(int a, int b) {
        long n = a*1L, k = b*1L, lo=0L, hi=1L + (n-1)/k, m;
        while(lo <= hi){
            m = lo + (hi-lo)/2;
            if(m*k*(m*k+1)/2 <= n) lo=m+1;
            else hi=m-1;
        }
        long t = Math.max(0L, lo-1);
        n = n - t*k*(t*k + 1)/2;
        
        Long[] ans = new Long[b];
        for(int i=0; i<b; i++){
            ans[i] = t*(i+1) + k*t*(t-1)/2;
            if(n > 0) {
                ans[i] += Math.min(n, k*t + i + 1);
                n -= k*t + i + 1;
            }
        }
        
        return ans;
    }
}
