package utils;

public class Trie {
    public Trie[] children;
    public boolean isWord=false;
    public int count=0;
    
    public Trie() {
        children = new Trie[26];
    }
    
    public void addString(String s){
        if(children[s.charAt(0)-'a'] == null) children[s.charAt(0)-'a'] = new Trie();
        Trie node = children[s.charAt(0)-'a'];
        node.count++;
        for(int i=1; i<s.length(); i++){
            if(node.children[s.charAt(i)-'a'] == null)
                node.children[s.charAt(i)-'a'] = new Trie();
            node = node.children[s.charAt(i)-'a'];
            node.count++;
        }
        node.isWord = true;
    }
    
    public String prefix(String s){
        StringBuilder sb = new StringBuilder();
        Trie node = children[s.charAt(0)-'a'];
        sb.append(s.charAt(0));
        int i=1;
        while(node.count > 1 && !node.isWord){
            node = node.children[s.charAt(i)-'a'];
            sb.append(s.charAt(i++));
        }
        return sb.toString();
    }
}
