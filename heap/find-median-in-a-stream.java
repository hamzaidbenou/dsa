package heap;

import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    static PriorityQueue<Integer> min = new PriorityQueue<>();
    static PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

    //Function to insert heap.
    public static void insertHeap(int x){
        if(min.size() == max.size()) {
            min.offer(x);
            max.offer(min.poll());
        } else {
            max.offer(x);
            min.offer(max.poll());
        }
    }
    
    //Function to return Median.
    public static double getMedian(){
        if(max.isEmpty()) return 0.0;
        
        if(min.size() == max.size()) {
            return (min.peek() + max.peek())/2.0;
        } else {
            return max.peek()/1.0;
        }
    }
    
}
