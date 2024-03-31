package linkedList;

import java.util.Stack;
import utils.DLL;

class Solution {
    
    /**
     * Given a Binary Tree (BT), convert it to a Doubly Linked List(DLL) In-Place. The left and right pointers in 
     * nodes are to be used as previous and next pointers respectively in converted DLL. The order of nodes in 
     * DLL must be same as Inorder of the given Binary Tree. The first node of Inorder traversal (leftmost node in BT) 
     * must be the head node of the DLL.
     * @param root
     * @return
     */
    public DLL bToDLL(DLL root){
        Stack<DLL> st = new Stack<>();
        DLL head=null, prev=null;
        
        while(!st.isEmpty() || root!=null){
            while(root!=null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(head==null) head= root;
            else{
                prev.right=root;
                root.left=prev;
            }
            prev = root;
            root = root.right;
        }
        
        return head;
    }
}
