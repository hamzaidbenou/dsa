package stack_queue;

import java.util.Stack;

class Solution {
    
    /**
     * Given a binary matrix M of size n X m. Find the maximum area of a rectangle formed only of 1s in the given matrix.
     * @param hist
     * @param m
     * @return
     */
    public int getMaxArea(int hist[], int m) {
        Stack<Integer> st = new Stack<>();
        int[] rectangles = new int[m];
        // right
        for(int i=m-1; i>=0; i--){
            while(!st.isEmpty() && hist[i] <= hist[st.peek()]) st.pop();
            if(st.isEmpty()) rectangles[i] = (m-i)*hist[i];
            else rectangles[i] = (st.peek()-i)*hist[i];
            st.push(i);
        }
        // left
        int ans = 0;
        st = new Stack<>();
        for(int i=0; i<m; i++){
            while(!st.isEmpty() && hist[i] <= hist[st.peek()]) st.pop();
            if(st.isEmpty()) rectangles[i] += i*hist[i];
            else rectangles[i] += (i-st.peek()-1)*hist[i];
            st.push(i);
            ans = Math.max(ans, rectangles[i]);
        }
        return ans;
    }
    public int maxArea(int M[][], int n, int m) {
        int hist[]=new int[m];
        int ans=0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(M[i][j] == 0) hist[j]=0;
                else hist[j]++;
            }
            ans = Math.max(ans, getMaxArea(hist,m));
        }
        return ans;
    }
}
