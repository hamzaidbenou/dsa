package trie;

import utils.Trie;

class Solution {

    /**
     * Given an array of words, find all shortest unique prefixes to represent each word in the given array.
     * Assume that no word is prefix of another.
     * @param arr
     * @param n
     * @return
     */
    public String[] findPrefixes(String[] arr, int n) {
        Trie root = new Trie();
        for(String s : arr) root.addString(s);
        
        String[] ans = new String[n];
        for(int i=0; i<n; i++) ans[i] = root.prefix(arr[i]);
        return ans;
    }
}
