package arrays;

import java.util.Arrays;

class Solution {

    /**
     * Given an array of strings arr[] of length n representing non-negative integers, arrange them in a manner, such that, 
     * after concatanating them in order, it results in the largest possible number. Since the result may be very large, 
     * return it as a string.
     * @param arr
     * @return
     */
    String printLargest(String[] arr) {
        Arrays.sort(arr, (a, b) -> compare(a,b));
        StringBuilder sb = new StringBuilder("");
        for(String s : arr) sb.append(s);
        return sb.toString();
    }
    
    public int compare(String a, String b){
        int i=0, j=0;
            while(i<a.length() && j<b.length() && a.charAt(i) == b.charAt(j)){
                i++;
                j++;
            }
            if(i==a.length() && j==b.length()) return 0;
            if(i==a.length()) return compare(b.substring(0,j), b.substring(j, b.length()));
            if(j==b.length()) return compare(a.substring(i, a.length()), a.substring(0, i));
            return b.charAt(j)-a.charAt(i);
    }
}
