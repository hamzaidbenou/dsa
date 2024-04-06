package arrays;

class Solution {
    
    /**
     * Given a boolean matrix of size RxC where each cell contains either 0 or 1, 
     * modify it such that if a matrix cell matrix[i][j] is 1 then all the cells in its ith row and jth column will become 1.
     * @param matrix
     */
    void booleanMatrix(int matrix[][]){
        boolean firstColumn = false;
        int n = matrix.length, m = matrix[0].length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++){
                if(j == 0) firstColumn = firstColumn || (matrix[i][j]==1);
                else {
                    if(matrix[i][j]==1){
                        matrix[i][0]=1;
                        matrix[0][j]=1;
                    }
                }
            }
        }
        // rows && columns
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++) {
                if(matrix[i][0] == 1 || matrix[0][j] == 1) matrix[i][j]=1;
            }
        }
        // first row
        if(matrix[0][0] == 1) {
            for(int j=1; j<m; j++) matrix[0][j]=1;
        }
        // first column
        if(firstColumn) {
            for(int i=0; i<n; i++) matrix[i][0]=1;
        }
    }
}