package utils;

public class ListNode {
    public int data, key;
    public ListNode next, arb, prev;

    public ListNode(int d) { data = d; }

    public ListNode(int k, int v){
        this.key=k;
        this.data=v;
    }
    
    public ListNode(int k, int v, ListNode n, ListNode p){
        this.key=k;
        this.data=v;
        this.next=n;
        this.prev=p;
    }
}
