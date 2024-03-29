package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import utils.TreeNode;

class Solution {
    /**
     * Given a Binary Tree, find the vertical traversal of it starting from the leftmost level to the rightmost level.
     * If there are multiple nodes passing through a vertical line, then they should be printed as they appear in level 
     * order traversal of the tree.
     * @param root
     * @return
     */
    static List<Integer> verticalOrder(TreeNode root){
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(root, 0));
        Node curr;
        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
        
        while(!q.isEmpty()){
            curr = q.poll();
            min = Math.min(min, curr.level);
            max = Math.max(max, curr.level);
            if(!map.containsKey(curr.level)) map.put(curr.level, new ArrayList<>());
            map.get(curr.level).add(curr.node.data);
            
            if(curr.node.left != null) q.offer(new Node(curr.node.left, curr.level-1));
            if(curr.node.right != null) q.offer(new Node(curr.node.right, curr.level+1));
        }
        List<Integer> ans = new ArrayList<Integer>();
        for(int i=min; i<=max; i++){
            if(map.containsKey(i)) ans.addAll(map.get(i));
        }
        return ans;
    }
    
    static class Node {
        TreeNode node;
        int level;
        
        public Node(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }
}
