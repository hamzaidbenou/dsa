package hashtable_sliding_window;

import java.util.HashMap;
import java.util.Map;

class Solution {

    /**
     * Given an array called A[] of sorted integers having no duplicates, find the length of the 
     * Longest Arithmetic Progression (LLAP) in it.
     * @param arr
     * @param n
     * @return
     */
    int lengthOfLongestAP(int[] arr, int n) {
        Map<String, Integer> dp = new HashMap<>();
        int ans=1, diff;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                diff = arr[j]-arr[i];
                dp.put(j + "|" + diff, dp.getOrDefault(i + "|" + diff, 1) + 1);
                ans = Math.max(ans, dp.get(j + "|" + diff));
            }
        }
        return ans;
    }
}