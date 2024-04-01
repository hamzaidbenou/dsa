package tree;

import utils.TreeNode;

class Tree {
    int diff = Integer.MIN_VALUE;

    /**
     * Given a Binary Tree, you need to find the maximum value which you can get by subtracting the value of node B 
     * from the value of node A, where A and B are two nodes of the binary tree and A is an ancestor of B. 
     * @param root
     * @return
     */
    int maxDiff(TreeNode root){
        maxDiffHelper(root);
        return diff;
    }
    
    int maxDiffHelper(TreeNode root){
        if(root == null) return Integer.MAX_VALUE;
        int min = Math.min(maxDiffHelper(root.left), maxDiffHelper(root.right));
        if(min == Integer.MAX_VALUE) return root.data;
        
        diff = Math.max(diff, root.data-min);
        return Math.min(root.data, min);
    }
}
