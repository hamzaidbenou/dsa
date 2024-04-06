package tree;

import java.util.Stack;

import utils.TreeNode;

class Solution {
    // Return the Kth smallest element in the given BST
    public int KthSmallestElement(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        while(!st.isEmpty() || root!=null) {
            while(root!=null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            k--;
            if(k==0) return root.data;
            root = root.right;
        }
        return -1;
    }
}
