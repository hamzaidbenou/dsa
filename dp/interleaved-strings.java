class Solution {
    int[][] dp; //1:false, 2:true;

    /**
     * Given strings A, B, and C, find whether C is formed by an interleaving of A and B.
     * An interleaving of two strings S and T is a configuration such that it creates a new 
     * string Y from the concatenation substrings of A and B and |Y| = |A + B| = |C|
     * For example: A = "XYZ", B = "ABC" 
     * so we can make multiple interleaving string Y like, XYZABC, XAYBCZ, AXBYZC, XYAZBC 
     * and many more so here your task is to check whether you can create a string Y which can be equal to C.
     * Specifically, you just need to create substrings of string A and create substrings B and concatenate 
     * them and check whether it is equal to C or not.
     * Note: a + b is the concatenation of strings a and b.
     * Return true if C is formed by an interleaving of A and B, else return false.
     * @param a
     * @param b
     * @param c
     * @return
     */
	public boolean isInterLeave(String a,String b,String c){
	    dp = new int[a.length()+1][b.length()+1];
         return isInterLeave(a, b, c, 0, 0, 0);
	}
	
	public boolean isInterLeave(String a,String b,String c,int i,int j,int k) {
	    if(i>=a.length() && j>=b.length() && k>=c.length()) return true;
	    if(dp[i][j] != 0) return dp[i][j]==2;
	    
	    boolean a_c = i<a.length() && k<c.length() && c.charAt(k)==a.charAt(i);
	    boolean b_c = j<b.length() && k<c.length() && c.charAt(k)==b.charAt(j);
        boolean ans = false;

        if(!a_c && !b_c) ans = false;
        else if(a_c && !b_c) ans = isInterLeave(a, b, c, i+1, j, k+1);
        else if(!a_c && b_c) ans = isInterLeave(a, b, c, i, j+1, k+1);
        else ans = isInterLeave(a, b, c, i+1, j, k+1) || isInterLeave(a, b, c, i, j+1, k+1);
        
        dp[i][j] = ans ? 2 : 1;
        return ans;
	}
}
