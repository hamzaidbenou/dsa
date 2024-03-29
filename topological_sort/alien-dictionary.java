package topological_sort;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

class Solution {
    Map<Integer, Set<Integer>> edges = new HashMap<>();
    Stack<Integer> st = new Stack<>();
    Set<Integer> visited = new HashSet<>();
    int[] states = new int[26];
    
    /**
     * Given a sorted dictionary of an alien language having N words and k starting alphabets of standard dictionary.
     * Find the order of characters in the alien language.
     * @param words
     * @param N
     * @param K
     * @return
     */
    public String findOrder(String[] words, int N, int K) {
        for(int i=0; i<N-1; i++) {
            if(!constructGraph(words[i], words[i+1])) return "";
        }

        Set<Integer> letters = new HashSet<>();
        for(String word : words) {
            for(int i=0; i<word.length(); i++) letters.add((int)word.charAt(i));
        }
        for(int c : letters) {
            if(!visited.contains(c)) {
                if(!dfs(c)) return "";
            }
        }

        StringBuilder sb = new StringBuilder("");
        while(!st.isEmpty()) sb.append((char)st.pop().intValue());
        return sb.reverse().toString();
    }

    public boolean dfs(int node) {
        visited.add(node);
        states[node - 'a'] = 1;
        for(int nei : edges.getOrDefault(node, new HashSet<>())) {
            if(states[nei - 'a'] == 2) continue;
            if(states[nei - 'a'] == 1) return false;
            
            if(!dfs(nei)) return false;
        }
        states[node - 'a'] = 2;
        st.push(node);
        return true;
    }

    public boolean constructGraph(String s1, String s2) {
        int i=0,j=0;
        while(i<s1.length() && j<s2.length() && s1.charAt(i)==s2.charAt(j)) {
            i++;
            j++;
        }
        if(j>=s2.length() && i<s1.length()) return false;

        if(i<s1.length() && j<s2.length()) {
            if(!edges.containsKey((int)s2.charAt(j))) {
                edges.put((int)s2.charAt(j), new HashSet<>());
            }
            edges.get((int)s2.charAt(j)).add((int)s1.charAt(i));
        }
        return true;
    }
}
