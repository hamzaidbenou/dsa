package tree;

import java.util.HashMap;
import java.util.Map;

import utils.TreeNode;

class Solution {
    static Map<TreeNode, int[]> map = new HashMap<>();

    /**
     * Given a binary tree with a value associated with each node, we need to choose a subset of these nodes 
     * such that sum of chosen nodes is maximum under a constraint that no two chosen node in subset should be 
     * directly connected that is, if we have taken a node in our sum then we can’t take its any children or parents 
     * in consideration and vice versa.
     * @param root
     * @return
     */
    static int getMaxSum(TreeNode root) {
        return Math.max(dfs(root, 1), dfs(root, 0));
    }
    
    static int dfs(TreeNode root, int include){
        if(root == null) return 0;
        if(map.containsKey(root)) {
            int[] curr = map.get(root);
            if(curr[include] != -1) return curr[include];
        }
        int max=-1;
        if(include == 1) {
            int l=dfs(root.left, 0), r=dfs(root.right, 0);
            max = root.data+l+r;
        } else {
            int li=dfs(root.left, 1), le=dfs(root.left, 0);
            int ri=dfs(root.right, 1), re=dfs(root.right, 0);
            max = Math.max(Math.max(li+ri, le+re), Math.max(li+re, le+ri));
        }
        if(!map.containsKey(root)) map.put(root, new int[]{-1,-1});
        map.get(root)[include] = max;
        return max;
    }
}
