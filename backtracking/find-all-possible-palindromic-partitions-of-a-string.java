package backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
    static List<List<String>> ans;
    static boolean[][] dp;
    
    /**
     * Given a String S, Find all possible Palindromic partitions of the given String.
     * @param s
     * @return
     */
    static List<List<String>> allPalindromicPerms(String s) {
        int n = s.length();
        dp = new boolean[n][n];
        ans = new ArrayList<>();
        
        for(int len=1; len<=n; len++){
            for(int i=0; i+len-1<n; i++){
                int j = i+len-1;
                if(i==j) dp[i][i] = true;
                else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && (i+1>j-1 || (i+1<=j-1 && dp[i+1][j-1]));
                }
            }
        }
        
        for(int i=0; i<n; i++) {
            if(dp[0][i]) {
                Deque<String> running = new LinkedList<>();
                running.addLast(s.substring(0, i+1));
                dfs(s, n, i+1, running);
                running.removeLast();
            }
        }
        return ans;
    }
    
    static void dfs(String s, int n, int j, Deque<String> q){
        if(j>=n) {
            ans.add(new ArrayList<>(q));
            return;
        }
        for(int i=0; i<n; i++) {
            if(dp[j][i]) {
                q.addLast(s.substring(j, i+1));
                dfs(s, n, i+1, q);
                q.removeLast();
            }
        }
    }
}
