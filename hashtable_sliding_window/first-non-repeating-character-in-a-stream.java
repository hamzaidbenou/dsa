package hashtable_sliding_window;

import java.util.HashMap;
import java.util.Map;

class Solution {

    /**
     * Given an input stream A of n characters consisting only of lower case alphabets. While reading characters 
     * from the stream, you have to tell which character has appeared only once in the stream upto that point.
     * If there are many characters that have appeared only once, you have to tell which one of them was the first 
     * one to appear. If there is no such character then append '#' to the answer.
     * NOTE:
     * 1. You need to find the answer for every i (0 <= i < n)
     * 2. In order to find the solution for every i you need to consider the string from starting position till ith position.
     * @param s
     * @return
     */
    public String FirstNonRepeating(String s){
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> occur = new HashMap<>();
        
        int l=0;
        for(int r=0; r<s.length(); r++) {
            int c = s.charAt(r)-'a';
            occur.put(c, 1+occur.getOrDefault(c, 0));
            if(occur.get(s.charAt(l)-'a') == 1) {
                sb.append(s.charAt(l));
            } else {
                while(l<=r && occur.get(s.charAt(l)-'a') > 1) l++;
                if(l > r) sb.append('#');
                else sb.append(s.charAt(l));
            }
        }
        
        return sb.toString();
    }
}
