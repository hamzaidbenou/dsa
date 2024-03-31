package hashtable_sliding_window;

class Solution {
    static int len = 'z'-'A' + 1;

    /**
     * Given two strings S and P. Find the smallest window in the string S consisting of all the 
     * characters(including duplicates) of the string P.  Return "-1" in case there is no such window present.
     * In case there are multiple such windows of same length, return the one with the least starting index.
     * @param s
     * @param t
     * @return
     */
    public static String smallestWindow(String s, String t){
        int n=s.length(), m=t.length();
        if(m > n) return "-1";
        int[] a = new int[len], b = new int[len];
        for(int i=0; i<m; i++) {
            a[s.charAt(i)-'A']++;
            b[t.charAt(i)-'A']++;
        }
        String ans = "";
        int i=m, minLen=Integer.MAX_VALUE, l=0;
        while(i <= n){
            while(i<n && !contains(a, b)) a[s.charAt(i++)-'A']++;
            if(contains(a, b)) {
                if((i-l) < minLen) ans = s.substring(l, i);
                minLen = Math.min(i-l, minLen);
                a[s.charAt(l++)-'A']--;
            } else return "".equals(ans) ? "-1" : ans;
        }
        return "".equals(ans) ? "-1" : ans;
    }
    
    static boolean contains(int[] s, int[] t) {
        for(int i=0; i<t.length; i++)
            if(t[i] > s[i]) return false;
        return true;
    }
}
