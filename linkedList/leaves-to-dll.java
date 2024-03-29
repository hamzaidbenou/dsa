package linkedList;

import utils.DLL;

class Tree {
    DLL head=null, prev=null;

    /**
     * Given a Binary Tree of size N, extract all its leaf nodes to form a Doubly Link List starting from 
     * the left most leaf. Modify the original tree to make the DLL thus removing the leaf nodes from the tree. 
     * Consider the left and right pointers of the tree to be the previous and next pointer of the DLL respectively.
     * Note: The generated output will contain the inorder traversal of the modified tree, the DLL from left to right 
     * and the DLL from right to left.
     * @param root
     * @return
     */
    public DLL convertToDLL(DLL root){
        dfs(root);
        return head;
    }
    
    public boolean dfs(DLL curr){
        if(isLeaf(curr)){
            if(head == null) head = curr;
            else {
                prev.right = curr;
                curr.left = prev;
            }
            prev = curr;
            return true;
        } else {
            if(curr.left != null){
                if(dfs(curr.left)) curr.left=null;
            }
            if(curr.right != null){
                if(dfs(curr.right)) curr.right=null;
            }
            return false;
        }
    }
    
    public boolean isLeaf(DLL node){
        return node.left==null && node.right==null;
    }
    
}
