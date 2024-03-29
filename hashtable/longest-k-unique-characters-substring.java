import java.util.HashMap;
import java.util.Map;

class Solution {
    /**
     * Given a string you need to print the size of the longest possible substring that has 
        exactly K unique characters. If there is no possible substring then print -1.
     * @param s
     * @param k
     */
    public int longestkSubstr(String s, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n=s.length(), ans=-1, l=0, c;
        for(int r=0; r<=n; r++){
            while(l < r && map.size() > k){
                c = s.charAt(l++);
                map.put(c, map.getOrDefault(c,0) - 1);
                if(map.get(c) <= 0) map.remove(c);
            }
            if(map.size() == k) ans = Math.max(ans, r-l);
            if(r < n){
                c = s.charAt(r);
                map.put(c, map.getOrDefault(c,0) + 1);
            }
        }
        return ans;
    }
    
}