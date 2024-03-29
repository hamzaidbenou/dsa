package linkedList;

import utils.ListNode;

class Solution {

    /**
     * Given a sorted linked list, delete all nodes that have duplicate numbers (all occurrences), 
     * leaving only numbers that appear once in the original list. 
     * @param head
     * @return
     */
    public static ListNode removeAllDuplicates(ListNode head){
        ListNode node=head, curr, prev=null;
        int cnt = 0;
        while(node != null){
            curr = node.next;
            while(curr!=null && curr.data==node.data) {
                curr = curr.next;
                cnt++;
            }
            
            if(cnt > 0){
                if(prev!=null) prev.next = curr;
                else head = curr;
            } else {
                prev = node;
            }
            node = curr;
            cnt = 0;
        }
        return head;
    }
}
