package linkedList;

import utils.ListNode;

class Solution {

    /**
     * Given a singly linked list: A0→A1→...→An-2→An-1, reorder it to: A0→An-1→A1→An-2→A2→An-3→...
     * @param head
     * @return
     */
    public ListNode reorderlist(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return head;
        
        ListNode slow=head, fast=head.next.next;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        
        ListNode mid = (fast==null) ? slow : slow.next;
        ListNode right = reverse(mid.next, null), left=head;
        mid.next = null;
        while(left!=null && right!=null){
            ListNode t1=left.next, t2=right.next;
            
            left.next=right;
            right.next=t1;
            
            left=t1;
            right=t2;
        }
        
        return head;
    }
    
    ListNode reverse(ListNode node, ListNode prev) {
        if(node==null) return prev;
        ListNode tmp=node.next;
        node.next=prev;
        return reverse(tmp, node);
    }
}
