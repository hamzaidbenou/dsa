package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import utils.TreeNode;

class Solution {
    
    /**
     * Given two BSTs, return elements of both BSTs in sorted form.
     * @param root1
     * @param root2
     * @return
     */
    public List<Integer> merge(TreeNode root1,TreeNode root2){
        Stack<TreeNode> st = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        mergeBST(root1, root2);
        while(!st.empty() || root1!=null) {
            while(root1!=null){
                st.push(root1);
                root1 = root1.left;
            }
            root1 = st.pop();
            ans.add(root1.data);
            root1 = root1.right;
        }
        return ans;
    }
    
    public void mergeBST(TreeNode root1, TreeNode root2){
        if(root2 == null) return;
        if(root1 == null) {
            root1 = root2;
            return;
        }
        insert(root1, root2);
        mergeBST(root1, root2.left);
        mergeBST(root1, root2.right);
    }
    
    public void insert(TreeNode root1, TreeNode node) {
        if(root1.left == null && root1.data >= node.data){
            root1.left = new TreeNode(node.data);
            return;
        }
        
        if(root1.right == null && root1.data < node.data){
            root1.right = new TreeNode(node.data);
            return;
        }
        
        if(root1.data >= node.data) insert(root1.left, node);
        else insert(root1.right, node);
    }
}
