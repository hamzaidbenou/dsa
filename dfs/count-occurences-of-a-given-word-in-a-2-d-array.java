package dfs;

class Solution {
    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};

    /**
     * Find the number of occurrences of a given search word in a 2d-Array of characters where the word 
     * can go up, down, left, right, and around 90-degree bends.
     * @param mat
     * @param t
     * @return
     */
    public int findOccurrence(char mat[][], String t){
        int n=mat.length, m=mat[0].length, ans=0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(mat[i][j] == t.charAt(0)){
                    mat[i][j] = '.';
                    ans += dfs(mat, i, j, 0, t, n, m);
                    mat[i][j] = t.charAt(0);
                }
            }
        }
        return ans;
    }
    
    public int dfs(char[][] mat, int i, int j, int k, String t, int n, int m){
        if(k >= t.length()-1) return 1;
        int ans = 0;
        for(int[] d : dir) {
            int r=i+d[0], c=j+d[1];
            if(r>=0 && r<n && c>=0 && c<m && mat[r][c] == t.charAt(k+1)){
                mat[r][c] = '.';
                ans += dfs(mat, r, c, k+1, t, n, m);
                mat[r][c] = t.charAt(k+1);
            }
        }
        return ans;
    }
}
