import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};

    /**
     * An image is represented by a 2-D array of integers, each integer representing the pixel value of the image.
     * Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel 
     * value newColor, "flood fill" the image. To perform a "flood fill", consider the starting pixel, plus any pixels 
     * connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels 
     * connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on.
     * Replace the color of all of the aforementioned pixels with the newColor.
     * @param img
     * @param i
     * @param j
     * @param newColor
     * @return
     */
    public int[][] floodFill(int[][] img, int i, int j, int newColor){
        int n=img.length, m=img[0].length;
        
        Queue<int[]> pts = new LinkedList<>();
        pts.offer(new int[]{i,j});
        int color = img[i][j];
        img[i][j] = newColor;
        boolean[][] visited = new boolean[n][m];
        visited[i][j] = true;
        
        while(!pts.isEmpty()){
            int k = pts.size();
            for(int l=0; l<k; l++){
                int[] curr = pts.poll();
                for(int[] d : dir) {
                    int r=curr[0]+d[0], c=curr[1]+d[1];
                    if(r>=0 && r<n && c>=0 && c<m && !visited[r][c] && img[r][c] == color){
                        pts.offer(new int[]{r,c});
                        img[r][c] = newColor;
                        visited[r][c] = true;
                    }
                }
            }
        }
        
        return img;
    }
}