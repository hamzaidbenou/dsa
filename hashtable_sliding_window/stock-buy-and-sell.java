package hashtable_sliding_window;

import java.util.ArrayList;
import java.util.List;

class Solution{

    //Function to find the days of buying and selling stock for max profit.
    List<List<Integer>> stockBuySell(int arr[], int n) {
        List<List<Integer>> ans = new ArrayList<>();
        int i=0, start=0;
        List<Integer> res;

        while(i<n) {
            start = i;
            while(i<n-1 && arr[i] <= arr[i+1]) i++;
            if(i > start) {
                res = new ArrayList<Integer>();
                res.add(start);
                res.add(i);
                ans.add(res);
            }
            i++;
        }
        
        return ans;
    }
}
