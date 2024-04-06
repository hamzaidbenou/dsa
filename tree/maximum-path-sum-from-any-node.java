package tree;

import utils.TreeNode;

class Solution {
    int max = Integer.MIN_VALUE;

    /**
     * Given a binary tree, the task is to find the maximum path sum. The path may start and end at any node in the tree.
     * @param node
     * @return
     */
    int findMaxSum(TreeNode node) {
        dfs(node);
        return max;
    }
    
    int dfs(TreeNode node) {
        if(node == null) return 0;

        int l = dfs(node.left);
        int r = dfs(node.right);
        int v = Math.max(Math.max(node.data + l, node.data + r), node.data);
        max = Math.max(max, Math.max(v, node.data + l + r));
        return v;
    }
}
