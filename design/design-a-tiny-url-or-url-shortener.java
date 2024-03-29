package design;

class Solution {

    /**
     * Design a system that takes big URLs like “http://www.geeksforgeeks.org/count-sum-of-digits-in-numbers-from-1-to-n/” and 
     * converts them into a short URL. It is given that URLs are stored in database and every URL has an associated integer id.
     * So your program should take an integer id and generate a URL. A URL character can be one of the following :
     * A lower case alphabet [‘a’ to ‘z’], total 26 characters
     * An upper case alphabet [‘A’ to ‘Z’], total 26 characters
     * A digit [‘0′ to ‘9’], total 10 characters
     * 
     * There are total 26 + 26 + 10 = 62 possible characters.
     * So the task is to convert an integer (database id) to a base 62 number where digits of 62 base are 
     * "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
     * @param n
     * @return
     */
    public String idToShortURL(long n) {
        String base62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder("");
        while(n != 0){
            sb.append(base62.charAt((int)(n%62)));
            n = n/62;
        }
        return sb.reverse().toString();
    }
}