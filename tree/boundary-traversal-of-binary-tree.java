package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import utils.TreeNode;

class Solution {

    /**
     * Given a Binary Tree, find its Boundary Traversal. The traversal should be in the following order:
     * 1 - Left boundary nodes: defined as the path from the root to the left-most node ie- the leaf node 
     * you could reach when you always travel preferring the left subtree over the right subtree.
     * 2 - Leaf nodes: All the leaf nodes except for the ones that are part of left or right boundary.
     * 3 - Reverse right boundary nodes: defined as the path from the right-most node to the root.
     * The right-most node is the leaf node you could reach when you always travel preferring the right 
     * subtree over the left subtree. Exclude the root from this as it was already included in the traversal 
     * of left boundary nodes.
     * Note: If the root doesn't have a left subtree or right subtree, then the root itself is the left or right boundary. 
     * @param node
     * @return
     */
	List<Integer> boundary(TreeNode node) {
	    List<Integer> ans = new ArrayList<Integer>();
	    if(node == null) return ans;

	    ans.add(node.data);
	    ans.addAll(leftAndLeafBoundary(node.left));
	    ans.addAll(rightBoundary(node.right));
	    return ans;
	}
	
	Deque<Integer> rightBoundary(TreeNode root) {
	    Deque<Integer> right = new LinkedList<>();
	    if(root == null) return right;

	    Stack<TreeNode> st = new Stack<>();
	    boolean stop = false;
	    while(!st.isEmpty() || root!=null) {
	        while(root!=null) {
	            st.push(root);
	            if(!stop) right.addFirst(root.data);
	            root = root.right;
	        }
	        root = st.pop();
	        if(root.left==null && root.right==null) {
	            if(stop) right.addFirst(root.data);
	            stop = true;
	        }
	        root = root.left;
	    }
	    return right;
	}
	
	Deque<Integer> leftAndLeafBoundary(TreeNode root) {
	    Deque<Integer> left = new LinkedList<>();
	    if(root == null) return left;

	    Stack<TreeNode> st = new Stack<>();
	    boolean stop = false;
	    while(!st.isEmpty() || root!=null) {
	        while(root!=null) {
	            st.push(root);
	            if(!stop) left.addLast(root.data);
	            root = root.left;
	        }
	        root = st.pop();
	        if(root.left==null && root.right==null) {
	            if(stop) left.addLast(root.data);
	            stop = true;
	        }
	        root = root.right;
	    }
	    return left;
	}
	
}
