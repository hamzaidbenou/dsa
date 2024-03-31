package stack_queue;

import java.util.Stack;

class Solution {
    
    /**
     * Find the largest rectangular area possible in a given histogram where the largest rectangle can be made 
     * of a number of contiguous bars. For simplicity, assume that all bars have the same width and the width is 1 unit,
     * there will be N bars height of each bar will be given by the array arr.
     * @param hist
     * @param m
     * @return
     */
    public static long getMaxArea(long hist[], long m) {
        Stack<Integer> st = new Stack<>();
        int n = (int)m;
        long[] rectangles = new long[n];
        // right
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && hist[i] <= hist[st.peek()]) st.pop();
            if(st.isEmpty()) rectangles[i] = (m-i*1L)*hist[i];
            else rectangles[i] = (st.peek()-i)*hist[i];
            st.push(i);
        }
        // left
        long ans = 0L;
        st = new Stack<>();
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && hist[i] <= hist[st.peek()]) st.pop();
            if(st.isEmpty()) rectangles[i] += i*hist[i];
            else rectangles[i] += (i-st.peek()-1)*hist[i];
            st.push(i);
            ans = Math.max(ans, rectangles[i]);
        }
        return ans;
    }
        
}
