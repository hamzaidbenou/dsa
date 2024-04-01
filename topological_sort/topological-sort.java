package topological_sort;

import java.util.List;
import java.util.Stack;

class Solution {
    static boolean[] visited;
    static Stack<Integer> st;
    
    /**
     * Given a Directed Acyclic Graph (DAG) with V vertices and E edges, Find any Topological Sorting of that Graph.
     * @param V
     * @param adj
     * @return
     */ 
    static int[] topoSort(int V, List<List<Integer>> adj){
        visited = new boolean[V];
        st = new Stack<>();
        for(int v=0; v<V; v++) if(!visited[v]) dfs(v, adj);
        int[] ans = new int[V];
        for(int i=0; i<V; i++) ans[i] = st.pop();
        return ans;
    }
    
    static void dfs(int i, List<List<Integer>> adj){
        visited[i] = true;
        for(int j : adj.get(i)){
            if(visited[j]) continue;
            dfs(j, adj);
        }
        st.push(i);
    }
}
