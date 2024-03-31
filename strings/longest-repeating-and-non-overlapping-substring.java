package strings;
import java.util.HashMap;
import java.util.Map;

class Solution {

    /**
     * Given a string s of length n, find the longest repeating non-overlapping substring in it.
     * In other words find 2 identical substrings of maximum length which do not overlap.
     * Return the longest non-overlapping substring. Return "-1" if no such string exists.
     * @param s
     * @param n
     * @return
     */
    static String longestSubstring(String s, int n) {
        String sub, ans="-1";
        Map<String, Integer> occur = new HashMap<>();
        
        for(int len=n/2; len>0; len--){
            for(int i=0; i+len<=n; i++){
                sub = s.substring(i, i+len);
                if(occur.containsKey(sub)) {
                    if(occur.get(sub) <= i) {
                        if("-1".equals(ans) || occur.get(ans) > occur.get(sub)) ans = sub;
                    }
                } else {
                    occur.put(sub, i+len);
                }
            }
            if(!"-1".equals(ans)) return ans;
        }
        return ans;
    }
}
