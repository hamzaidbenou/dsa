import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution { 
    
    /**
     * Given N numbers in an array, your task is to keep at most the top K numbers with respect to their frequency.
        In other words, you have to iterate over the array, and after each index, determine the top K most frequent 
        numbers until that iteration and store them in an array in decreasing order of frequency. An array will be 
        formed for each iteration and stored in an array of arrays. If the total number of distinct elements is less 
        than K, then keep all the distinct numbers in the array. If two numbers have equal frequency, place the smaller 
        number first in the array.
     * @param arr
     * @param n
     * @param k
     */
    static List<Integer> kTop(int[] arr, int n, int k){
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();
        int[] top = new int[k+1];
        int j;
        for(int i=0; i<n; i++){
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
            top[k] = arr[i];
            j = find(top, arr[i])-1;
            while(j >= 0) {
                if(
                    freq.getOrDefault(top[j],0) < freq.getOrDefault(top[j+1],0) || 
                    (freq.getOrDefault(top[j],0) == freq.getOrDefault(top[j+1],0) && top[j] > top[j+1])
                ){
                    int tmp = top[j];
                    top[j] = top[j+1];
                    top[j+1] = tmp;
                } else break;
                j--;
            }
            for(int l=0; l<k && top[l]!=0; l++) ans.add(top[l]);
        }
        return ans;
    }
    
    static int find(int[] arr, int t) {
        for(int i=0; i<arr.length; i++) if(arr[i] == t) return i;
        return -1;
    }
}