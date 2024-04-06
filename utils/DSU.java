package utils;

public class DSU {
    public int[] parent;
        
    public DSU(int n) {
        parent = new int[n];
        for(int i=0; i<n; i++) parent[i]=i;
    }
    
    public int find(int i) {
        if(parent[i] != i) parent[i]=find(parent[i]);
        return parent[i];
    }
    
    public void union(int i, int j) {
        parent[find(i)] = find(j);
    }
    
    public int numberOfParent() {
        int cnt=0;
        for(int i=0; i<parent.length; i++) {
            if(parent[i] == i) cnt++;
        }
        return cnt;
    }
}
