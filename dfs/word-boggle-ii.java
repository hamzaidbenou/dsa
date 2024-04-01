package dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    int[][] ns = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
    List<String> words = new ArrayList<>();

    /**
     * Geek and his friends went on a trip to one of the hill stations in Geekland. While trekking they found a treasure map,
     * it was in the form of r x c size board, each cell on the map denotes a latin uppercase letter. On the bottom of 
     * the map it was written that there are n gates with a specific name and if they could find out the name of 
     * the gate on the map that gate would open. Help Geek and his friends to find out the gates they could possibly 
     * open with the map they found. A name can be formed by a sequence of adjacent characters on the map.
     * We can move to any of 8 adjacent characters. While forming a word we can move to any of the 8 adjacent cells.
     * A cell can be used only once in one name. NOTE: All gate names returned must be different even it occurs multiple 
     * times in the input.
     * @param board
     * @param dictionary
     * @return
     */
    public String[] wordBoggle(char board[][], String[] dictionary){
        Set<String> set = new HashSet<>();
        for(String word : dictionary) {
            if(set.add(word) && contains(word, board)) words.add(word);
        }
        String[] ans = new String[words.size()];
        return words.toArray(ans);
    }
    
    public boolean contains(String word, char board[][]){
        int n=board.length, m=board[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++) {
                if(board[i][j]==word.charAt(0)) {
                    board[i][j] = '*';
                    if(dfs(word, 1, i, j, board)) {
                        board[i][j] = word.charAt(0);
                        return true;
                    }
                    board[i][j] = word.charAt(0);
                }
            }
        }
        return false;
    }
    
    public boolean dfs(String word, int pos, int i, int j, char board[][]){
        if(pos == word.length()) return true;
        int n=board.length, m=board[0].length;
        for(int[] direction : ns){
            int r=i+direction[0], c=j+direction[1];
            if(r>=0 && r<n && c>=0 && c<m && board[r][c]==word.charAt(pos)){
                board[r][c] = '*';
                if(dfs(word, pos+1, r, c, board)) {
                    board[r][c] = word.charAt(pos);
                    return true;
                }
                board[r][c] = word.charAt(pos);
            }
        }
        return false;
    }
}
