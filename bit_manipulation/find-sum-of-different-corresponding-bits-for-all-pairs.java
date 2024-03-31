package bit_manipulation;

class Solution {

    /**
     * We define f (X, Y) as number of different corresponding bits in binary representation of X and Y.
     * For example, f (2, 7) = 2, since binary representation of 2 and 7 are 010 and 111, respectively.
     * The first and the third bit differ, so f (2, 7) = 2.
     * You are given an array A of N integers, A1, A2 ,…, AN. Find sum of f(Ai, Aj) for all ordered 
     * pairs (i, j) such that 1 ≤ i, j ≤ N. Return the answer modulo 10^9+7.
     * @param n
     * @param arr
     * @return
     */
    public int countBits(int n, long[] arr) {
        int mod = (int)1e9 + 7;
        long[] bits = new long[32];
        long cnt=0L;
        for(int i=0; i<n; i++) {
            int j=0, x=(int)arr[i];
            while(x!=0) {
                bits[j++] += (x&1);
                x = x >> 1;
            }
        }
        for(int i=0; i<32; i++)
            cnt += 2L*(n*1L - bits[i])*bits[i];
        return (int)(cnt%mod);
    }
}
