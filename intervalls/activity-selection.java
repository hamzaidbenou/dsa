package intervalls;

import java.util.Arrays;

class Solution {
    
    /**
     * Given N activities with their start and finish day given in array start[ ] and end[ ].
     * Select the maximum number of activities that can be performed by a single person, 
     * assuming that a person can only work on a single activity at a given day.
     * @param start
     * @param end
     * @param n
     * @return
     */
    public static int activitySelection(int start[], int end[], int n){
        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++) arr[i] = new int[]{start[i], end[i]};
        Arrays.sort(arr, (a,b) -> a[1]-b[1]);
        
        int i=0, cnt=1;
        for(int j=1; j<n; j++) {
            if(arr[j][0] > arr[i][1]) {
                i = j;
                cnt++;
            }
        }
        return cnt;
    }
}
