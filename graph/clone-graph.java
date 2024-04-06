package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import utils.Node;

class Solution{
    
    /**
     * Given a connected undirected graph with n nodes and m edges, with each node having a distinct 
     * label from 0 to n-1, create a clone of the graph. Each node in the graph contains an integer val 
     * and an array (neighbors) of nodes, containing nodes that are adjacent to the current node.
     * @param node
     * @return
     */
    Node cloneGraph(Node node){
        Map<Node, Node> clones = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        q.offer(node);
        visited.add(node);
        clones.put(node, new Node(node.val));
        
        while(!q.isEmpty()) {
            Node curr = q.poll();
            for(Node nei : curr.neighbors) {
                if(!clones.containsKey(nei)) clones.put(nei, new Node(nei.val));
                clones.get(curr).neighbors.add(clones.get(nei));
                if(!visited.contains(nei)) {
                    q.offer(nei);
                    visited.add(nei);
                }
            }
        }
        
        return clones.get(node);
    }
}
