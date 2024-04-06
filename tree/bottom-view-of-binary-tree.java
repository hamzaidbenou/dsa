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
     * Given a binary tree, print the bottom view from left to right.
     * A node is included in bottom view if it can be seen when we look at the tree from bottom.
     * @param root
     * @return
     */
    public List<Integer> bottomView(TreeNode root){
        List<Integer> ans = new ArrayList<Integer>();
	    if(root == null) return ans;
	    
	    int min=0, max=0;
	    Map<Integer, TreeNode> map = new HashMap<>();
	    Queue<TreeNode> nodes = new LinkedList<>();
        root.pos = 0;
	    nodes.offer(root);
	    map.put(0, root);
	    
	    while(!nodes.isEmpty()){
	        int k=nodes.size();
	        for(int i=0; i<k; i++) {
	            TreeNode curr = nodes.poll();
	            if(curr.left != null) {
	                min = Math.min(min, curr.pos-1);
	                map.put(curr.pos-1, curr.left);
                    curr.left.pos = curr.pos-1;
	                nodes.offer(curr.left);
	            }
	            if(curr.right != null) {
	                max = Math.max(max, curr.pos+1);
	                map.put(curr.pos+1, curr.right);
                    curr.right.pos = curr.pos+1;
	                nodes.offer(curr.right);
	            }
	        }
	    }
	    for(int i=min; i<=max; i++) {
	        if(map.containsKey(i)) ans.add(map.get(i).data);
	    }
	    return ans;
    }
}
