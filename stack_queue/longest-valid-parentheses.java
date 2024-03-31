package stack_queue;

import java.util.Stack;

class Solution {
    
    /**
     * Given a string S consisting of opening and closing parenthesis '(' and ')'. Find length of the longest 
     * valid parenthesis substring.
     * A parenthesis string is valid if:
     * For every opening parenthesis, there is a closing parenthesis.
     * Opening parenthesis must be closed in the correct order.
     * @param S
     * @return
     */
    static int maxLength(String S){
        Stack<Integer> st = new Stack<>();
        int ans=0;
        for(int i=0; i<S.length(); i++){
            char c = S.charAt(i);
            if(c == '(') st.push(0);
            else {
                if(st.isEmpty()) st.push(-1);
                else {
                    int sum = 0;
                    while(!st.isEmpty() && st.peek()>0) sum+=st.pop();
                    if(st.isEmpty() || (!st.isEmpty() && st.peek()!=0)) {
                        st.push(sum);
                        st.push(-1);
                    } else {
                        sum +=2;
                        st.pop();
                        while(!st.isEmpty() && st.peek()>0) sum+=st.pop();
                        st.push(sum);
                        ans = Math.max(ans, sum);
                    }
                }
            }
        }
        return ans;
    }
}
