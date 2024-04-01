package dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    boolean[] visited;
    Stack<Integer> nodes;
    
    /**
     * Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges,
     * Find the number of strongly connected components in the graph.
     * @param V
     * @param adj
     * @return
     */
    public int kosaraju(int V, List<List<Integer>> adj){
        List<List<Integer>> reverse = new ArrayList<>();
        for(int i=0; i<V; i++) reverse.add(new ArrayList<>());
        for(int i=0; i<V; i++){
            for(int j : adj.get(i)) reverse.get(j).add(i);
        }
        int cnt=0;
        // dfs on the graph
        visited = new boolean[V];
        nodes = new Stack<>();
        for(int i=0; i<V; i++) if(!visited[i]) dfs(i, adj);
        // dfs on the reverse graph
        visited = new boolean[V];
        while(!nodes.isEmpty()){
            int i = nodes.pop();
            if(visited[i]) continue;
            dfsReverse(i, reverse);
            cnt++;
        }
        return cnt;
    }
    
    public void dfsReverse(int i, List<List<Integer>> adj){
        visited[i] = true;
        for(int j : adj.get(i)){
            if(visited[j]) continue;
            dfsReverse(j, adj);
        }
    }
    
    public void dfs(int i, List<List<Integer>> adj){
        visited[i] = true;
        for(int j : adj.get(i)){
            if(visited[j]) continue;
            dfs(j, adj);
        }
        nodes.push(i);
    }
}