package dsu;

import java.util.List;

import utils.DSU;

class Solution {

    /**
     * Given an undirected graph with V vertices. We say two vertices u and v belong to a single province 
     * if there is a path from u to v or v to u. Your task is to find the number of provinces.
     * Note: A province is a group of directly or indirectly connected cities and no other cities outside of the group.
     * @param adj
     * @param V
     * @return
     */
    static int numProvinces(List<List<Integer>> adj, int V) {
        DSU dsu = new DSU(V);
        for(int i=0; i<V; i++) {
            for(int j=i+1; j<V; j++) {
                if(adj.get(i).get(j) == 1) dsu.union(i, j);
            }
        }
        return dsu.numberOfParent();
    }
}
