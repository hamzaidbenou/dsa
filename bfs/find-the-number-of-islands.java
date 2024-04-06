import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
    
    /**
     * Given a grid of size n*m (n is the number of rows and m is the number of columns in the grid) 
     * consisting of '0's (Water) and '1's(Land). Find the number of islands.
     * Note: An island is either surrounded by water or boundary of grid and is formed by connecting 
     * adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int n=grid.length, m=grid[0].length, ans=0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == '1') {
                    bfs(grid, i, j, n, m);
                    ans++;
                }
            }
        }
        return ans;
    }
    
    public void bfs(char[][] grid, int i, int j, int n, int m) {
        Queue<int[]> pts = new LinkedList<>();
        pts.offer(new int[]{i,j});
        grid[i][j] = '0';
        
        while(!pts.isEmpty()){
            int k = pts.size();
            for(int l=0; l<k; l++){
                int[] curr = pts.poll();
                for(int[] d : dir) {
                    int r=curr[0]+d[0], c=curr[1]+d[1];
                    if(r>=0 && r<n && c>=0 && c<m && grid[r][c] == '1'){
                        pts.offer(new int[]{r,c});
                        grid[r][c] = '0';
                    }
                }
            }
        }
    }
}