package linkedList;

import java.util.HashMap;
import java.util.Map;
import utils.ListNode;

class Solution {
    
    /**
     * clone a linked list with next and random pointer.
     * @param head
     * @return
     */
    public ListNode copyList(ListNode head) {
        if(head == null) return null;
        Map<ListNode, ListNode> map = new HashMap<>();
        map.put(head, new ListNode(head.data));
        ListNode root = head;
        
        while(root!=null){
            if(root.next!=null){
                if(!map.containsKey(root.next)) map.put(root.next, new ListNode(root.next.data));
                map.get(root).next = map.get(root.next);
            }
            if(root.arb!=null) {
                if(!map.containsKey(root.arb)) map.put(root.arb, new ListNode(root.arb.data));
                map.get(root).arb = map.get(root.arb);
            }
            root = root.next;
        }
        
        return map.get(head);
    }
}
