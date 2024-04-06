package dfs;

import java.util.ArrayList;
import java.util.List;

class Solution {
    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};

    /**
     * Given a dictionary of distinct words and an M x N board where every cell has one character.
     * Find all possible words from the dictionary that can be formed by a sequence of adjacent characters on the board.
     * We can move to any of 8 adjacent characters
     * Note: While forming a word we can move to any of the 8 adjacent cells. A cell can be used only once in one word.
     * @param board
     * @param dictionary
     * @return
     */
    public String[] wordBoggle(char board[][], String[] dictionary){
        int n=board.length, m=board[0].length;
        List<String> ans = new ArrayList<>();
        for(String w : dictionary) {
            if(wordBoggle(board, w, n, m)) ans.add(w);
        }
        String[] res = new String[ans.size()];
        for(int i=0; i<ans.size(); i++) res[i]=ans.get(i);
        return res;
    }
    
    public boolean wordBoggle(char board[][], String word, int n, int m){
        boolean[][] visited = new boolean[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if(dfs(board, visited, word, i, j, 1, n, m)) return true;
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(char board[][], boolean[][] visited, String word, int i, int j, int k, int n, int m) {
        if(k == word.length()) return true;
        
        for(int[] d : dir) {
            int r=i+d[0], c=j+d[1];
            if(r>=0 && r<n && c>=0 && c<m && !visited[r][c] && board[r][c] == word.charAt(k)){
                visited[r][c] = true;
                if(dfs(board, visited, word, r, c, k+1, n, m)) return true;
                visited[r][c] = false;
            }
        }
        return false;
    }
}
