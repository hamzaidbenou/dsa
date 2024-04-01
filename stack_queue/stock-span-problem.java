package stack_queue;

import java.util.Stack;

class Solution {
    
    /**
     * The stock span problem is a financial problem where we have a series of n daily price quotes for a stock 
     * and we need to calculate the span of stocks price for all n days. The span Si of the stocks price on a given 
     * day i is defined as the maximum number of consecutive days just before the given day, for which the price of 
     * the stock on the given day is less than or equal to its price on the current day.
     * For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values 
     * for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}.
     * @param price
     * @param n
     * @return
     */
    public static int[] calculateSpan(int price[], int n){
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && price[i] >= price[st.peek()]) st.pop();
            ans[i] = st.isEmpty() ? (i+1) : (i-st.peek());
            st.push(i);
        }
        return ans;
    }
    
}
