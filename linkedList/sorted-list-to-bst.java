package linkedList;

import utils.ListNode;
import utils.TreeNode;

class Solution {

    /**
     * Given a Singly Linked List which has data members sorted in ascending order.
     * Construct a Balanced Binary Search Tree which has same data members as the given Linked List.
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head){
        if(head == null) return null;
        
        //get the mid node
        ListNode slow=head, fast=head, prev=null;
        while(fast!=null && fast.next!=null) {
            prev=slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode ans = new TreeNode(slow.data);
        ListNode right = slow.next;
        slow.next = null;
        
        if(prev != null)
            prev.next=null;
        else
            return ans;
        
        ans.left = sortedListToBST(head);
        ans.right = sortedListToBST(right);
        return ans;
    }
}
