import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {

    /**
     * Given an adjacency list of a graph adj of V no. of vertices having 0 based index. Check whether the graph is bipartite or not.
     * @param V
     * @param adj
     * @return
     */
    public boolean isBipartite(int V, List<List<Integer>>adj){
        Map<Integer, Boolean> partition = new HashMap<>();
        for(int v=0; v<V; v++){
            if(partition.containsKey(v)) continue;
            Queue<Integer> q = new LinkedList<>();
            q.offer(v);
            partition.put(v, true);
            while(!q.isEmpty()){
                int curr = q.poll();
                for(int n : adj.get(curr)){
                    if(!partition.containsKey(n)){
                        partition.put(n, !partition.get(curr));
                        q.offer(n);
                    } else {
                        if(partition.get(curr) == partition.get(n)) return false;
                    }
                }
            }
        }
        
        return true;
    }
}