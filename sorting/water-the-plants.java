package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    /**
     * A gallery with plants is divided into n parts, numbered : 0,1,2,3...n-1. There are provisions for attaching water 
     * sprinklers at every partition. A sprinkler with range x at partition i can water all partitions from i-x to i+x.
     * Given an array gallery[ ] consisting of n integers, where gallery[i] is the range of sprinkler at partition i 
     * (power==-1 indicates no sprinkler attached), return an array denoting the indexes of sprinklers needed to water the garden.
     * If there is no possible way to water the full length using the given sprinklers, return an array containing -1.
     * @param gallery
     * @param n
     * @return
     */
    int min_sprinklers(int gallery[], int n){
        List<int[]> intervals = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(gallery[i] == -1) continue;
            intervals.add(new int[]{Math.max(0, i-gallery[i]), Math.min(n-1, i+gallery[i])});
        }
        if(intervals.size() == 0) return -1;
        Collections.sort(intervals, (a,b)->{
            if(a[0] == b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        int ans=0, i=0, currPlant=0, farPlant=0;
        while(farPlant < n) {
            if(i==intervals.size() || intervals.get(i)[0] > farPlant) return -1;
            currPlant = intervals.get(i)[1];
            while(i+1 < intervals.size() && intervals.get(i+1)[0] <= farPlant){
                currPlant = Math.max(currPlant, intervals.get(++i)[1]);
            }
            if(currPlant < farPlant) return -1;
            ans++;
            farPlant = currPlant+1;
            i++;
        }
        return ans;
    }
}
