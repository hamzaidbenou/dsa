package strings;

import java.util.HashMap;
import java.util.Map;

class Solution {

    /**
     * Given a string S which only contains lowercase alphabets. Find the length of the longest substring of S such 
     * that the characters in it can be rearranged to form a palindrome.
     * @param s
     * @return
     */
    static int longestSubstring(String s) {
        int n=s.length(), ans=0, mask=0;
        Map<Integer, Integer> seen = new HashMap<>();
        seen.put(mask, -1);
        for(int i=0; i<n; i++){
            int c = s.charAt(i)-'a';
            mask ^= (1<<c);
            if(seen.containsKey(mask)) ans = Math.max(ans, i-seen.get(mask));
            else seen.put(mask, i);
            // the ans has 2*k length, we search for the max 2*k+1 length
            for(int j=0; j<26; j++){
                int tmp = mask^(1<<j);
                if(seen.containsKey(tmp)) ans = Math.max(ans, i-seen.get(tmp));
            }
        }
        return ans;
    }
}
