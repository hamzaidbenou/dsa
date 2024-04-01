import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    static Map<Integer, Boolean> dp;

    /**
     * Given a string s and a dictionary of n words dictionary, find out if "s" can be segmented 
     * into a space-separated sequence of dictionary words.
     * Return 1 if it is possible to break the s into a sequence of dictionary words, else return 0.
     * Note: From the dictionary dictionary each word can be taken any number of times and in any order.
     * @param A
     * @param B
     * @return
     */
    public static int wordBreak(String A, ArrayList<String> B){
        dp = new HashMap<>();
        return wordBreak(A, A.length(), 0, 1, new HashSet<>(B)) ? 1 : 0;
    }
    
    public static boolean wordBreak(String s, int n, int l, int r, Set<String> words){
        if(l >= n) return true;
        if(dp.containsKey(l)) return dp.get(l);
        
        String sub = s.substring(l, Math.min(r, n));
        boolean ans = false;
        if(r >= n) ans = words.contains(sub);
        else {
            if(words.contains(sub)) ans = wordBreak(s, n, r, r+1, words);
            ans = ans || wordBreak(s, n, l, r+1, words);
        }
        
        dp.put(l, ans);
        return dp.get(l);
    }
}