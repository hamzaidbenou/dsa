package linkedList;

import utils.TreeNode;

class Solution {

    /**
     * Given the root of a binary tree, flatten the tree into a "Linked list":
     * The "linked list" should use the same Node class where the right child pointer points to the next node in 
     * the list and the left child pointer is always null.
     * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
     * @param root
     */
    public static void flatten(TreeNode root){
        dfs(root);
    }
    
    public static TreeNode[] dfs(TreeNode root){
        if(root == null) return new TreeNode[]{null, null};
        if(root.left == null && root.right==null) return new TreeNode[]{root, root};
        TreeNode[] left = dfs(root.left);
        TreeNode[] right = dfs(root.right);
        
        if(root.left != null && root.right!=null) {
            root.right = left[0];
            left[1].right = right[0];
            root.left = null;
            return new TreeNode[]{root, right[1]};
        }
        if(root.left != null){
            root.right = left[0];
            root.left = null;
            return new TreeNode[]{root, left[1]};
        }
        root.right = right[0];
        return new TreeNode[]{root, right[1]};
    }
}
