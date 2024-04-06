import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};

    /**
     * Given  a grid of n*m consisting of O's and X's. The task is to find the number of 'X' total shapes.
     * Note: 'X' shape consists of one or more adjacent X's (diagonals not included).
     * @param grid
     * @return
     */
    public int xShape(char[][] grid) {
        int n=grid.length, m=grid[0].length, ans=0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 'X') {
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
        grid[i][j] = 'O';
        
        while(!pts.isEmpty()){
            int k = pts.size();
            for(int l=0; l<k; l++){
                int[] curr = pts.poll();
                for(int[] d : dir) {
                    int r=curr[0]+d[0], c=curr[1]+d[1];
                    if(r>=0 && r<n && c>=0 && c<m && grid[r][c] == 'X'){
                        pts.offer(new int[]{r,c});
                        grid[r][c] = 'O';
                    }
                }
            }
        }
    }
}