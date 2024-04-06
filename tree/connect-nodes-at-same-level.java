package tree;

import java.util.LinkedList;
import java.util.Queue;

import utils.TreeNode;

class Solution {
    //Function to connect nodes at same level.
    public void connect(TreeNode root){
        if(root == null) return;
	    Queue<TreeNode> nodes = new LinkedList<>();
	    nodes.offer(root);
	    
	    while(!nodes.isEmpty()){
	        int k=nodes.size();
	        TreeNode prev = null;
	        for(int i=0; i<k; i++) {
	            TreeNode curr = nodes.poll();
	            if(prev != null) prev.nextRight = curr;
	            prev = curr;
	            if(curr.left!=null) nodes.offer(curr.left);
	            if(curr.right!=null) nodes.offer(curr.right);
	        }
	    }
    }
}
