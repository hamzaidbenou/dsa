package binary_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    /**
     * Given two integer arrays Arr1 and Arr2 of size N. Use the greatest elements from the given arrays to create a 
     * new array of size N such that it consists of only unique elements and the sum of all its elements is maximum.
     * The created elements should contain the elements of Arr2 followed by elements of Arr1 in order of their appearance.
     * @param arr1
     * @param arr2
     * @param n
     * @return
     */
    public List<Integer> maximizeArray(int[] arr1, int[] arr2, int n) {
        Map<Integer, Integer> map2 = new HashMap<>();
        for(int j=0; j<n; j++) if(!map2.containsKey(arr2[j])) map2.put(arr2[j], j);
        Integer[] nums2 = new Integer[map2.size()];
        int i=0;
        for(int e : map2.keySet()) nums2[i++]=e;
        i = 0;
        Map<Integer, Integer> map1 = new HashMap<>();
        for(int j=0; j<n; j++) if(!map2.containsKey(arr1[j]) && !map1.containsKey(arr1[j])) map1.put(arr1[j], j);
        Integer[] nums1 = new Integer[map1.size()];
        for(int e : map1.keySet()) nums1[i++]=e;
        
        List<Integer> ans = maximizeArray(nums1, nums2, n, nums1.length, nums2.length);
        Collections.sort(ans, (a, b) -> {
            int a1 = map2.getOrDefault(a, map1.get(a));
            int a2 = map2.containsKey(a) ? 0 : 1;
            int b1 = map2.getOrDefault(b, map1.get(b));
            int b2 = map2.containsKey(b) ? 0 : 1;
            if(a2 == b2) return a1-b1;
            return a2-b2;
        });
        return ans;
    }
    
    public List<Integer> maximizeArray(Integer[] arr1, Integer[] arr2, int n, int n1, int n2) {
        Arrays.sort(arr1, Collections.reverseOrder());
        Arrays.sort(arr2, Collections.reverseOrder());
        List<Integer> ans = new ArrayList<Integer>();
        if(n >= n1+n2) {
            for(int i=0; i<n2; i++) ans.add(arr2[i]);
            for(int i=0; i<n1; i++) ans.add(arr1[i]);
            return ans;
        }
        
        int min = Integer.MIN_VALUE;
        int l=0, r=n2-1, mid, ll, rl, lr, rr;
        while(l <= r) {
            mid = l+(r-l)/2;
            ll = arr2[mid];
            rl = (mid+1 < n2) ? arr2[mid+1] : min;
            lr = (n-mid-2 >= 0 && n-mid-2 < n1) ? arr1[n-mid-2] : min;
            rr = (n-mid-1 >= 0 && n-mid-1 < n1) ? arr1[n-mid-1] : min;
            if(ll >= rr && lr >= rl) {
                for(int i=0; i<=mid; i++) ans.add(arr2[i]);
                for(int i=0; i<=(n-mid-2); i++) ans.add(arr1[i]);
                return ans;
            } else {
                if(ll < rr) r = mid-1;
                else l = mid+1;
            }
        }
        if(l >= n2) {
            for(int i=0; i<n2; i++) ans.add(arr2[i]);
            for(int i=0; i<=n-n2-1; i++) ans.add(arr1[i]);
        } else {
            for(int i=0; i<=n-n1-1; i++) ans.add(arr2[i]);
            for(int i=0; i<n1; i++) ans.add(arr1[i]);
        }
        return ans;
    }
}
