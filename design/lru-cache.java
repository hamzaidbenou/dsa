package design;

import java.util.HashMap;
import java.util.Map;

import utils.ListNode;


/**
 * Design a data structure that works like a LRU Cache. Here cap denotes the capacity of the cache and Q denotes 
 * the number of queries. Query can be of two types:
 * SET x y: sets the value of the key x with value y
 * GET x: gets the key of x if present else returns -1.
 * The LRUCache class has two methods get() and set() which are defined as follows.
 * get(key): returns the value of the key if it already exists in the cache otherwise returns -1.
 * set(key, value): if the key is already present, update its value. If not present, 
 * add the key-value pair to the cache. If the cache reaches its capacity it should invalidate 
 * the least recently used item before inserting the new item.
 * In the constructor of the class the capacity of the cache should be initialized.
 */
class LRUCache {
    static Map<Integer, ListNode> cache = null;
    static int size=0;
    static ListNode head=null;
    static ListNode tail=null;
    
    //Constructor for initializing the cache capacity with the given value.
    LRUCache(int cap){
        size = cap;
        cache = new HashMap<>();
        head = null;
        tail = null;
    }

    //Function to return value corresponding to the key.
    public static int get(int key) {
        if(!cache.containsKey(key)) return -1;
        int value = cache.get(key).data;
        update(key, value);
        return value;
    }

    //Function for storing key-value pair.
    public static void set(int key, int value) {
        if(cache.containsKey(key)) {
            update(key, value);
        } else {
            if(cache.size() == size) evict();
            addNode(key, value);
        }
    }
    
    public static void addNode(int key, int value) {
        ListNode node = new ListNode(key, value, head, null);
        if(head!=null) head.prev = node;
        head = node;
        if(tail==null) tail=node;
        cache.put(key, node);
    }
    
    public static void update(int key, int value) {
        ListNode curr = cache.get(key);
        curr.data = value;

        ListNode pr=curr.prev, ne=curr.next;
        if(pr!=null) pr.next=ne;
        else return;
        
        if(ne!=null) ne.prev=pr;
        else {
            tail=pr;
            tail.next=null;
        }

        curr.next = head;
        if(head!=null) head.prev = curr;
        curr.prev = null;
        head = curr;
    }
    
    public static void evict() {
        if(tail == null) return;
        
        cache.remove(tail.key);
        ListNode tmp = tail.prev;
        tail.prev = null;
        tail = tmp;
        
        if(tail != null) tail.next = null;
        else head=null;
    }
}
