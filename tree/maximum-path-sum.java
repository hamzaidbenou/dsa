package tree;

import utils.TreeNode;

class Solution {
    int max = Integer.MIN_VALUE;

    /**
     * Given a binary tree in which each node element contains a number. Find the maximum possible path sum 
     * from one special node to another special node.
     * @param root
     * @return
     */
    int maxPathSum(TreeNode root){
        dfs(root);
        if(root.left!=null && root.right!=null)
            return max;
        return Math.max(max, root.data);
    } 
    
    void dfs(TreeNode root){ 
        if(root == null) return;
        if(root.left == null && root.right == null) return;
        
        dfs(root.left);
        dfs(root.right);
        
        int l=getValue(root.left), r=getValue(root.right);
        if(root.left!=null && root.right!=null) max = Math.max(max, root.data+l+r);
        
        root.data += Math.max(l, r);
    }
    
    int getValue(TreeNode root) {
        return (root==null) ? Integer.MIN_VALUE : root.data;
    }
}