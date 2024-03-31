package strings;

import java.util.HashSet;
import java.util.Set;

class Solution { 
    Set<String> pls;

    /**
     * Given a string str of lowercase ASCII characters, Count the number of distinct continuous 
     * palindromic sub-strings which are present in the string str.
     * @param str
     * @return
     */
    int palindromeSubStrs(String str) {
        int n=str.length();
        pls = new HashSet<>();
        for(int i=0; i<n; i++){
            palindrome(str, n, i, i);
            palindrome(str, n, i, i+1);
        }
        return pls.size();
    }
    
    public void palindrome(String s, int n, int l, int r){
        while(l>=0 && r<n && s.charAt(l)==s.charAt(r)) pls.add(s.substring(l--, ++r));
    }
} 
