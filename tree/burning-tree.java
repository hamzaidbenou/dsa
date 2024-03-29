package tree;

import java.util.Deque;
import java.util.LinkedList;
import utils.TreeNode;

class Solution {
    
    /**
     * Given a binary tree and a node data called target. Find the minimum time required to burn the complete binary tree 
     * if the target is set on fire. It is known that in 1 second all nodes connected to a given node get burned.
     * That is its left child, right child, and parent. Note: The tree contains unique values.
     * @param root
     * @param target
     * @return
     */
    public static int minTime(TreeNode root, int target){
        Deque<TreeNode> path = new LinkedList<>();
        dfs(root, target, path);
        TreeNode curr, prev=path.pollLast();
        int min_time=0, target_height=height(prev)-1, distance=1, tmp;

        while(!path.isEmpty()){
            curr = path.pollLast();
            
            if(isLeft(curr, prev.data)) tmp=height(curr.right);
            else tmp = height(curr.left);
            
            min_time = Math.max(min_time, tmp + distance);
            prev = curr;
            distance++;
        }
        
        return Math.max(target_height, min_time);
    }
    
    public static boolean dfs(TreeNode root, int target, Deque<TreeNode> q){
        if(root == null) return false;
        q.addLast(root);
        if(root.data == target) return true;
        
        if(dfs(root.left, target, q)) return true;
        if(dfs(root.right, target, q)) return true;
        
        q.pollLast();
        return false;
    }
    
    public static boolean isLeft(TreeNode root, int target){
        return root.left!=null && root.left.data==target;
    }
    
    public static int height(TreeNode root){
        if(root == null) return 0;
        return  1+Math.max(height(root.left), height(root.right));
    }
}
