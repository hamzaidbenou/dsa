package maths;

class Solution {

    /**
     * Given a positive integer N. You have to find Nth natural number after removing all the numbers containing digit 9.
     * @param n
     * @return
     */
    public long findNth(long n){
        long ans = 0L, pw=1L;
        while(n != 0){
            ans += (n%9)*pw;
            n = n/9;
            pw = pw*10;
        }
        return ans;
    }
}
