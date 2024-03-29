package sorting;

import utils.ListNode;

class Solution {

    /**
     * You are given a Linked List. Sort the given Linked List using quicksort. 
     * @param node
     * @return
     */
    public static ListNode quickSort(ListNode node){
        return quickSortHelper(node)[0];
    }
    
    public static ListNode[] quickSortHelper(ListNode node){
        if(node == null) return new ListNode[]{null,null};
        
        ListNode left=null, prev_left=null;
        ListNode right=null, prev_right=null;
        
        ListNode pivot = node, tmp=node.next;
        node.next = null;
        node = tmp;
        
        while(node != null){
            tmp = node.next;
            node.next = null;
            if(node.data <= pivot.data){
                if(left == null) left = node;
                else prev_left.next = node;
                prev_left = node;
            } else {
                if(right == null) right = node;
                else prev_right.next = node;
                prev_right = node;
            }
            node = tmp;
        }
        
        ListNode[] lefts = quickSortHelper(left), rights = quickSortHelper(right);
        if(lefts[0]==null && rights[0]==null) return new ListNode[]{pivot,pivot};
        if(lefts[0]!=null && rights[0]!=null){
            lefts[1].next = pivot;
            pivot.next = rights[0];
            return new ListNode[]{lefts[0],rights[1]};
        }
        if(lefts[0]!=null){
            lefts[1].next = pivot;
            return new ListNode[]{lefts[0],pivot};
        } else {
            pivot.next = rights[0];
            return new ListNode[]{pivot,rights[1]};
        }
    }    
}
