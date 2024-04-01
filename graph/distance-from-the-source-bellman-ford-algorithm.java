package graph;

import java.util.Arrays;
import java.util.List;

class Solution {

    /**
     * Given a weighted and directed graph of V vertices and E edges, Find the shortest distance of all the vertex's 
     * from the source vertex S. If a vertices can't be reach from the S then mark the distance as 10^8.
     * Note: If the Graph contains a negative cycle then return an array consisting of only -1.
     * @param V
     * @param edges
     * @param S
     * @return
     */
    static int[] bellman_ford(int V, List<List<Integer>> edges, int S) {
        int max = (int)(1e8);
        int[] dist = new int[V];
        Arrays.fill(dist, max);
        dist[S] = 0;
        for(int v=0; v<V; v++){
            for(List<Integer> e : edges) {
                if(dist[e.get(0)]!=max && dist[e.get(1)] > dist[e.get(0)] + e.get(2)) {
                    dist[e.get(1)] = dist[e.get(0)] + e.get(2);
                }
            }
        }
        for(List<Integer> e : edges) {
            if(dist[e.get(0)]+e.get(2) < dist[e.get(1)]) return new int[]{-1};
        }
        return dist;
    }
}
