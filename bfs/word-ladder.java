import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {

    /**
     * Given two distinct words startWord and targetWord, and a list denoting wordList of unique words of equal lengths.
     * Find the length of the shortest transformation sequence from startWord to targetWord.
     * Keep the following conditions in mind:
     * A word can only consist of lowercase characters.
     * Only one letter can be changed in each transformation.
     * Each transformed word must exist in the wordList including the targetWord.
     * startWord may or may not be part of the wordList
     * @param startWord
     * @param targetWord
     * @param wordList
     * @return
     */
    public int wordLadderLength(String startWord, String targetWord, String[] wordList){
        Set<String> words = new HashSet<>();
        for(String s : wordList) words.add(s);
        if(!words.contains(targetWord)) return 0;
        
        int steps=0;
        Queue<String> q = new LinkedList<>();
        q.offer(startWord);
        words.remove(startWord);
        StringBuilder sb;
        
        while(!q.isEmpty()){
            int k=q.size();
            for(int l=0; l<k; l++) {
                sb = new StringBuilder(q.poll());
                if(targetWord.equals(sb.toString())) return 1+steps;
                
                for(int i=0; i<sb.length(); i++) {
                    char c = sb.charAt(i);
                    for(int j=0; j<26; j++) {
                        if(c == (char)(j + 'a')) continue;
                        sb.setCharAt(i, (char)(j + 'a'));
                        if(words.contains(sb.toString())) {
                            q.offer(sb.toString());
                            words.remove(sb.toString());
                        }
                    }
                    sb.setCharAt(i, c);
                }
            }
            steps++;
        }
        return 0;
    }
}