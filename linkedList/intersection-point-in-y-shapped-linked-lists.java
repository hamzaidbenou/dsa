package linkedList;

import utils.ListNode;

class Intersect {
    
    /**
     * Given two singly linked lists of size N and M, write a program to get the point where two linked lists intersect each other.
     * @param head1
     * @param head2
     * @return
     */
	int intersectPoint(ListNode head1, ListNode head2){
         ListNode p1=head1, p2=head2;
         while(p1!=p2){
             p1 = p1.next;
             p2 = p2.next;
             if(p1==null && p2==null) return -1;
             if(p1 == null) p1 = head2;
             if(p2 == null) p2 = head1;
         }
         return p1!=null ? p1.data : -1;
	}
}
