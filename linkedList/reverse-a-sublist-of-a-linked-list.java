package linkedList;

import utils.ListNode;

class Solution {

    /**
     * Given a linked list and positions m and n. Reverse the linked list from position m to n.
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int m, int n){
        ListNode prev=null, start=head, end=head;
        for(int i=1; i<n; i++) {
            if(i<m) {
                prev = start;
                start=start.next;
                if(start==null) return head;
            }
            end = end.next;
            if(end == null) break;
        }
        
        ListNode tail = (end != null) ? end.next : null;
        if(end != null) end.next = null;
        
        end = start;
        ListNode curr = reverseList(start, null);
        
        end.next = tail;
        if(prev != null) prev.next = curr;
        else return curr;
        
        return head;
    }
    
    static ListNode reverseList(ListNode head, ListNode curr){
        if(head == null) return curr;
        ListNode tmp = head.next;
        head.next = curr;
        return reverseList(tmp, head);
    }
}
