package stack_queue;

import java.util.Stack;

class Solution {
    
    /**
     * Find the next greater element for each element of the array.
     * @param arr
     * @param n
     * @return
     */
    public static long[] nextLargerElement(long[] arr, int n){ 
        long[] ans = new long[n];
        Stack<Long> st = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && arr[i] >= st.peek()) st.pop();
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
        }
        return ans;
    } 
}
