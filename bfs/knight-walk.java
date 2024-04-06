import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[][] dir = {{1,2},{-1,2},{1,-2},{-1,-2},{2,1},{-2,1},{2,-1},{-2,-1}};

    /**
     * Given a square chessboard, the initial position of Knight and position of a target.
     * Find out the minimum steps a Knight will take to reach the target position.If it cannot 
     * reach the target position return -1.
     * Note: The initial and the target position co-ordinates of Knight have been given accoring to 1-base indexing.
     * @param KnightPos
     * @param TargetPos
     * @param n
     * @return
     */
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int n){
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        int steps = 0;
        
        q.offer(new int[]{KnightPos[0]-1, KnightPos[1]-1});
        visited[KnightPos[0]-1][KnightPos[1]-1] = true;
        
        while(!q.isEmpty()) {
            int k = q.size();
            for(int i=0; i<k; i++) {
                int[] curr = q.poll();
                if(curr[0]==TargetPos[0]-1 && curr[1]==TargetPos[1]-1) return steps;
                
                for(int[] d : dir) {
                    int r = curr[0]+d[0], c = curr[1]+d[1];
                    if(r>=0 && r<n && c>=0 && c<n && !visited[r][c]) {
                        q.offer(new int[]{r,c});
                        visited[r][c] = true;
                    }
                }
            }
            steps++;
        }
        return 0;
    }
}