package arrays;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {

    /**
     * Given a number, in the form of an array Num[] of size N containing digits from 1 to 9(inclusive).
     * The task is to find the next smallest palindrome strictly larger than the given number.
     * @param num
     * @param n
     * @return
     */
    public List<Integer> generateNextPalindrome(int num[], int n) {
        Deque<Integer> ans = new LinkedList<>();
        int mid=(n-1)/2, step=0, left=mid-n%2, right=mid+1;
        
        while(left-step>=0 && num[left-step]==num[right+step]) step++;
        
        int val = (left>=step && num[left-step]>num[right+step]) ? 0 : 1;
        if(n%2==1) {
            ans.addFirst((num[mid]+val)%10);
            val = (num[mid]+val)/10;
        }
        
        for(int i=0; i<step; i++){
            ans.addLast((num[left-i]+val)%10);
            ans.addFirst((num[left-i]+val)%10);
            val = (num[left-i]+val)/10;
        }
        
        if(left>=step) {
            ans.addLast(num[left-step]+val);
            ans.addFirst(num[left-step]+val);
        } else {
            if(!ans.isEmpty() && ans.peekLast()==0) {
                ans.removeLast();
                ans.addLast(1);
                ans.addFirst(1);
            }
        }
        
        for(int i=left-step-1; i>=0; i--){
            ans.addLast(num[i]);
            ans.addFirst(num[i]);
        }
        return new ArrayList<Integer>(ans);
    }
}
