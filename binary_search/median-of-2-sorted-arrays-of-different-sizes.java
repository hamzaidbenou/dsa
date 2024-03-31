package binary_search;

class Solution {
    
    /**
     * Given two sorted arrays array1 and array2 of size m and n respectively. Find the median of the two sorted arrays.
     * @param n
     * @param m
     * @param A
     * @param B
     * @return
     */
    public static double medianOfArrays(int n, int m, int A[], int B[]) {
        if (n > m)
            return medianOfArrays(m, n, B, A);
 
        int start = 0;
        int end = n;
        int realmidinmergedarray = (n + m + 1) / 2;
 
        while (start <= end) {
            int mid = (start + end) / 2;
            int leftAsize = mid;
            int leftBsize = realmidinmergedarray - mid;
            int leftA = (leftAsize > 0) ? A[leftAsize - 1] : Integer.MIN_VALUE;
            int leftB = (leftBsize > 0) ? B[leftBsize - 1] : Integer.MIN_VALUE;
            int rightA = (leftAsize < n) ? A[leftAsize] : Integer.MAX_VALUE;
            int rightB = (leftBsize < m) ? B[leftBsize] : Integer.MAX_VALUE;

            if (leftA <= rightB && leftB <= rightA) {
                if ((m + n) % 2 == 0)
                    return (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0;
                return Math.max(leftA, leftB);
            } else if (leftA > rightB) {
                end = mid - 1;
            } else
                start = mid + 1;
        }
        return 0.0;
    }
}
