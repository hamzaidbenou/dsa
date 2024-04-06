package graph;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    
    /**
     * Given a weighted, undirected and connected graph of V vertices and an adjacency list adj where 
     * adj[i] is a list of lists containing two integers where the first integer of each list j denotes 
     * there is edge between i and j , second integers corresponds to the weight of that edge .
     * You are given the source vertex S and You to Find the shortest distance of all the vertex's 
     * from the source vertex S. You have to return a list of integers denoting shortest distance 
     * between each node and Source vertex S.
     * Note: The Graph doesn't contain any negative weight cycle.
     * @param V
     * @param adj
     * @param S
     * @return
     */
    static int[] dijkstra(int V, List<List<List<Integer>>> adj, int S){
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> min = new PriorityQueue<>((a, b) -> a[2]-b[2]);
        dist[S] = 0;
        min.offer(new int[]{S,S,0});
        while(!min.isEmpty()) {
            int[] edge = min.poll();
            for(List<Integer> t : adj.get(edge[1])) {
                if(dist[t.get(0)] > t.get(1) + dist[edge[1]]){
                    dist[t.get(0)] = t.get(1) + dist[edge[1]];
                    min.offer(new int[]{edge[1],t.get(0),t.get(1)});
                }
            }
        }
        return dist;
    }
}
