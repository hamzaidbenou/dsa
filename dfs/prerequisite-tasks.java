package dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    Map<Integer, Set<Integer>> edges = new HashMap<>();
    String[] states;

    /**
     * There are a total of N tasks, labeled from 0 to N-1. Some tasks may have prerequisites, 
     * for example to do task 0 you have to first complete task 1, which is expressed as a pair: [0, 1]
     * Given the total number of tasks N and a list of prerequisite pairs P, find if it is possible to finish all tasks.
     * @param N
     * @param prerequisites
     * @return
     */
    public boolean isPossible(int N, int[][] prerequisites){
        states = new String[N];
        for(int[] e : prerequisites) {
            if(!edges.containsKey(e[0])) edges.put(e[0], new HashSet<>());
            edges.get(e[0]).add(e[1]);
        }
        for(int i=0; i<N; i++) {
            if(!dfs(i)) return false;
        }
        return true;
    }
    
    public boolean dfs(int i) {
        states[i] = "PENDING";
        for(int j : edges.getOrDefault(i, new HashSet<>())) {
            if("DONE".equals(states[j])) continue;
            if("PENDING".equals(states[j])) return false;
            if(!dfs(j)) return false;
        }
        states[i] = "DONE";
        return true;
    }
    
}
