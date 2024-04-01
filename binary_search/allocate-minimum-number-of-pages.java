package binary_search;

class Solution {
    
    /**
     * You have N books, each with A[i] number of pages. M students need to be allocated contiguous books, with each 
     * student getting at least one book. Out of all the permutations, the goal is to find the permutation where 
     * the sum of maximum number of pages in a book allotted to a student should be minimum, out of all possible permutations.
     * Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order.
     * @param A
     * @param N
     * @param M
     * @return
     */
    public static int findPages(int[]A,int N,int M){
        if(M>N) return -1;
        int l=0,r=0;
        for(int a : A){
            l = Math.max(a,l);
            r += a;
        }
        while(l <= r){
            int mid = l+(r-l)/2, sum=0, cnt=1;
            for(int a: A){
                sum += a;
                if(sum > mid){
                    sum = a;
                    cnt++;
                }
            }
            if(cnt > M) l=mid+1;
            else r=mid-1;
        }
        return r+1;
    }
}
