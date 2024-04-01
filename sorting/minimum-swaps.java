package sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    
    /**
     * Find the minimum number of swaps required to sort the array.
     * @param nums
     * @return
     */
    public int minSwaps(int nums[]){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) map.put(nums[i], i);
        boolean[] visited = new boolean[nums.length];
        int ans = 0;
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++) {
            if(visited[i] || map.get(nums[i]) == i) continue;
            int j = i, cnt=0;
            while(!visited[j]) {
                visited[j] = true;
                j = map.get(nums[j]);
                cnt++;
            }
            ans += (cnt>0) ? (cnt-1) : 0;
        }
        return ans;
    }
    
    public int mergeSort(int[] arr, int l, int r) {
        int swaps = 0, mid;
        if(l<r){
            mid = l+(r-l)/2;
            swaps += mergeSort(arr, l, mid);
            swaps += mergeSort(arr, mid+1, r);
            swaps += mergeSortAndCount(arr, l, mid, r);
        }
        return swaps;
    }
    public int mergeSortAndCount(int[] arr, int l, int m, int r) {
        int[] left = Arrays.copyOfRange(arr, l, m+1);
        int[] right = Arrays.copyOfRange(arr, m+1, r+1);
        int i=0, j=0, k=l, swaps=0;
        while(i<left.length && j<right.length){
            if(left[i] <= right[j]) arr[k++]=left[i++];
            else {
                arr[k++]=right[j++];
                swaps += m+1-(l+i);
            }
        }
        while(i<left.length) arr[k++]=left[i++];
        while(j<right.length) arr[k++]=right[j++];
        return swaps;
    }
}
