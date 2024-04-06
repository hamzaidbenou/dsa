package arrays;

class Solution{
    
    /**
     * Given an array arr[] of N non-negative integers representing the height of blocks.
     * If width of each block is 1, compute how much water can be trapped between the blocks during the rainy season. 
     * @param arr
     * @param n
     * @return
     */
    static long trappingWater(int arr[], int n) { 
        int[] left=new int[n], right=new int[n];
        left[0] = arr[0];
        for(int i=1; i<n; i++) left[i] = Math.max(left[i-1], arr[i]);
        right[n-1] = arr[n-1];
        for(int i=n-2; i>=0; i--) right[i] = Math.max(right[i+1], arr[i]);
        long volume = 0L;
        for(int i=0; i<n; i++) volume += 1L*(Math.min(left[i], right[i])-arr[i]);
        return volume;
    } 
}