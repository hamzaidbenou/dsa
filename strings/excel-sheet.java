package strings;

class Solution {

    /**
     * Given a positive integer N, return its corresponding column title as it would appear in an Excel sheet.
     * For N =1 we have column A, for 27 we have AA and so on.
     * @param n
     * @return
     */
    public String excelColumn(int n){
        StringBuilder sb = new StringBuilder();
        while(n != 0){
            sb.append((char)(((n-1)%26) + 'A'));
            n = (n-1)/26;
        }
        return sb.reverse().toString();
    }
}
