package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import utils.TreeNode;

class Solution {
    //Function to store the zig zag order traversal of tree in a list.
	List<Integer> zigZagTraversal(TreeNode root){
	    List<Integer> ans = new ArrayList<Integer>();
	    if(root == null) return ans;

	    Deque<TreeNode> nodes = new LinkedList<>();
	    nodes.addLast(root);
	    boolean left_to_right = false;
	    while(!nodes.isEmpty()){
	        int k=nodes.size();
	        for(int i=0; i<k; i++) {
	            TreeNode curr = (left_to_right) ? nodes.pollLast() : nodes.pollFirst();
	            ans.add(curr.data);
	            
	            if(left_to_right) {
	                if(curr.right!=null) nodes.addFirst(curr.right);
	                if(curr.left!=null) nodes.addFirst(curr.left);
	            } else {
	                if(curr.left!=null) nodes.addLast(curr.left);
	                if(curr.right!=null) nodes.addLast(curr.right);
	            }
	        }
	        left_to_right = !left_to_right;
	    }
	    return ans;
	}
}
