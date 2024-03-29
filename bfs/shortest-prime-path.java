import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class Solution{

    /**
     * You are given two four digit prime numbers num1 and num2. Find the distance of the shortest 
     * path from Num1 to Num2 that can be attained by altering only single digit at a time such that 
     * every number that we get after changing a digit is a four digit prime number with no leading zeros.
     * @param n1
     * @param n2
     * @return
     */
    int solve(int n1,int n2){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        Set<Integer> visited = new HashSet<>();
        pq.offer(new int[]{n1, 0});
        int[] curr;
        int n3, pw;
        while(!pq.isEmpty()){
            curr = pq.poll();
            if(curr[0] == n2) return curr[1];
            if(visited.contains(curr[0])) continue;
            visited.add(curr[0]);
            
            for(int i=0; i<4; i++){
                for(int j=0; j<10; j++){
                    if(i==0 && j==0) continue;
                    pw = (int)Math.pow(10, 4-i-1);
                    n3 = (curr[0]/(10*pw))*pw*10 + j*pw + curr[0]%pw;
                    if(isPrime(n3) && !visited.contains(n3)){
                        pq.offer(new int[]{n3, 1+curr[1]});
                    }
                }
            }
        }
        
        return -1;
    }
    
    boolean isPrime(int n){
        if(n==1 || n%2==0 || n%3==0) return false;
        int k=1;
        while((6*k-1)*(6*k-1) <= n){
            if(n%(6*k+1)==0 || n%(6*k-1)==0) return false;
            k++;
        }
        return true;
    }
}