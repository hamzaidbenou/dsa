package strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    int[] primes = new int[]{2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101};

    /**
     * Given an array of strings, return all groups of strings that are anagrams. The groups must be created in 
     * order of their appearance in the original array. Look at the sample case for clarification.
     * @param string_list
     * @return
     */
    public List<List<String>> Anagrams(String[] string_list) {
        long prod = 1L;
        Map<Long, List<String>> map = new HashMap<>();
        for(String s : string_list) {
            prod = 1L;
            for(int i=0; i<s.length(); i++) prod *= primes[s.charAt(i)-'a'];
            if(!map.containsKey(prod)) map.put(prod, new ArrayList<>());
            map.get(prod).add(s);
        }
        
        List<List<String>> ans = new ArrayList<>();
        for(long key : map.keySet()) ans.add(map.get(key));
        Collections.sort(ans, (a, b) -> a.get(0).compareTo(b.get(0)));
        
        return ans;
    }
}
