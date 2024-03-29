package intervalls;

import java.util.Arrays;
import java.util.Stack;

class Solution {

    /**
     * Given a collection of Intervals, the task is to merge all of the overlapping Intervals.
     * @param intervals
     * @return
     */
    public int[][] overlappedInterval(int[][] intervals){
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        Stack<int[]> st = new Stack<>();
        st.push(intervals[0]);

        for(int i=1; i<intervals.length; i++){
            if(st.peek()[1] >= intervals[i][0]){
                st.push(new int[]{st.peek()[0], Math.max(st.pop()[1], intervals[i][1])});
            } else {
                st.push(intervals[i]);
            }
        }
        int[][] ans = new int[st.size()][2];
        for(int i=ans.length-1; i>=0; i--) ans[i] = st.pop();
        
        return ans;
    }
}
