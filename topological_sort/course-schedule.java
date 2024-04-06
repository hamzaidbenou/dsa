package topological_sort;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

class Solution {
    static int[] states; // 1: pending, 2: done
    static Stack<Integer> st; // 1: pending, 2: done
    static Map<Integer, Set<Integer>> edges;

    /**
     * There are a total of n tasks you have to pick, labelled from 0 to n-1.
     * Some tasks may have prerequisite tasks, for example to pick task 0 you have to first finish tasks 1,
     * which is expressed as a pair: [0, 1]
     * Given the total number of n tasks and a list of prerequisite pairs of size m.
     * Find a ordering of tasks you should pick to finish all tasks.
     * Note: There may be multiple correct orders, you just need to return any one of them.
     * If it is impossible to finish all tasks, return an empty array.
     * @param n
     * @param m
     * @param prerequisites
     * @return
     */
    static int[] findOrder(int n, int m, List<List<Integer>> prerequisites) {
        states = new int[n];
        st = new Stack<>();
        edges = new HashMap<>();
        
        for(List<Integer> edge : prerequisites) {
            if(!edges.containsKey(edge.get(0))) edges.put(edge.get(0), new HashSet<>());
            edges.get(edge.get(0)).add(edge.get(1));
        }
        
        for(int i=0; i<n; i++) {
            if(states[i] == 2) continue;
            if(!dfs(i)) return new int[0];
        }
        int[] order = new int[n];
        for(int i=n-1; i>=0; i--) order[i] = st.pop();
        return order;
    }
    
    static boolean dfs(int i) {
        states[i] = 1;
        
        for(int j : edges.getOrDefault(i, new HashSet<>())) {
            if(states[j] == 2) continue;
            if(states[j] == 1) return false;
            if(!dfs(j)) return false;
        }
        
        states[i] = 2;
        st.push(i);
        return true;
    }
    
}
