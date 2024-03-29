package linkedList;

import utils.ListNode;

class Solution {
    
    /**
     * Given a linked list of N nodes such that it may contain a loop.
     * A loop here means that the last node of the link list is connected to the node at position X(1-based index).
     * If the link list does not have any loop, X=0.
     * Remove the loop from the linked list, if it is present, i.e. unlink the last node which is forming the loop.
     * @param head
     */
    public static void removeLoop(ListNode head){
        // detect loop
        ListNode slow=head, fast=head, prev=null, tmp=head;
        while(fast!=null && fast.next!=null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
            // detect the loop
            if(slow == fast){
                while(slow != tmp) {
                    prev = slow;
                    slow = slow.next;
                    tmp = tmp.next;
                }
                prev.next = null;
                return;
            }
        }
    }
}
