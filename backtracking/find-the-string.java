package backtracking;

import java.util.HashSet;
import java.util.Set;

class Solution{

    /**
     * Given two integers N and K, the task is to find the string S of minimum length such that it contains all 
     * possible strings of size N as a substring. The characters of the string should be from integers ranging from 0 to K-1.  
     * @param n
     * @param k
     * @return
     */
    public String findString(int n, int k) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append('0');
		}
		Set<String> visited = new HashSet<>();
		visited.add(sb.toString());
		// there are n conbinations of k digits
		dfs(sb, (int) Math.pow(k, n), visited, n, k);

		return sb.toString();
	}

	private boolean dfs(StringBuilder sb, int all, Set<String> visited, int n, int k) {
        if (visited.size()==all) {
            return true;
        }
        StringBuilder prev = new StringBuilder(sb.substring(sb.length()-n+1));
        for (int i=0; i<k; i++) {
            prev.append(i);
            if (visited.add(prev.toString())) {
                sb.append(i);
                if (dfs(sb, all, visited, n, k)) {
                    return true;
                } 
                visited.remove(prev.toString());
                sb.deleteCharAt(sb.length()-1);
            }
            prev.deleteCharAt(prev.length()-1);
        }
        return false;
    }
}
