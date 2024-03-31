class Solution{

    /**
     * Given an array p[] of length n used to denote the dimensions of a series of matrices such that the dimension 
     * of i'th matrix is p[i] * p[i+1]. There are a total of n-1 matrices. Find the most efficient way to multiply 
     * these matrices together.
     * As in MCM, you were returning the most effective count but this time return the string which is formed 
     * of A - Z (only Uppercase) denoting matrices & Brackets( "(" ")" ) denoting multiplication symbols.
     * For example, if n =11, the matrixes can be denoted as A - K as n<=26 & brackets as multiplication symbols.
     * @param mat
     * @param n
     * @return
     */
    public static String matrixChainOrder(int mat[], int n){
        Bracket[][] dp = new Bracket[n][n];
        Matrix[] arr = new Matrix[n-1];
        for(int i=0; i<n-1; i++) arr[i]=new Matrix(Character.toString((char)('A'+i)), mat[i], mat[i+1]);
        
        for(int len=1; len<n; len++){
            for(int i=0; (i+len)<n; i++) {
                int j = i+len-1;
                if(i==j) {
                    dp[i][j] = new Bracket(arr[i].name, 0);
                } else {
                    int min=Integer.MAX_VALUE;
                    String chain = "";
                    for(int k=i+1; k<=j; k++) {
                        if(min > dp[i][k-1].cost+dp[k][j].cost+arr[i].r*arr[k].r*arr[j].c) {
                            min = dp[i][k-1].cost+dp[k][j].cost+arr[i].r*arr[k].r*arr[j].c;
                            chain = "(" +dp[i][k-1].chain + dp[k][j].chain + ")";
                        }
                    }
                    dp[i][j] = new Bracket(chain, min);
                }
                
                
            }
        }
        return dp[0][n-2].chain;
    }
    
    static class Matrix {
        String name;
        int r;
        int c;
        public Matrix(String s, int i, int j) {
            name = s;
            r = i;
            c = j;
        }
    }
    
    static class Bracket {
        String chain;
        int cost;
        public Bracket(String c, int v) {
            chain = c;
            cost = v;
        }
    }
}