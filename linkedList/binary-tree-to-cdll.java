package linkedList;

import java.util.Stack;

import utils.TreeNode;

class Solution { 
    
    /**
     * Given a Binary Tree of N edges. The task is to convert this to a Circular Doubly Linked List (CDLL) in-place.
     * The left and right pointers in nodes are to be used as previous and next pointers respectively in CDLL.
     * The order of nodes in CDLL must be same as Inorder of the given Binary Tree.
     * The first node of Inorder traversal (left most node in BT) must be head node of the CDLL.
     * @param root
     * @return
     */
    TreeNode bTreeToClist(TreeNode root){
        TreeNode head=null, prev=null;
        Stack<TreeNode> st = new Stack<>();
        
        while(!st.isEmpty() || root!=null){
            while(root!=null){
                st.push(root);
                root=root.left;
            }
            root = st.pop();
            if(head == null) head = root;
            else {
                prev.right = root;
                root.left = prev;
            }
            prev = root;
            root = root.right;
        }
        if(head != null && prev != null){
            prev.right = head;
            head.left = prev;
        }
        return head;
    }
    
}
