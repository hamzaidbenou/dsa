package bit_manipulation;

class Solution {

    /**
     * Given an array arr[] of N positive integers. Find an integer denoting the maximum XOR subset value in the given array arr[].
     * @param arr
     * @param n
     * @return
     */
    public static int maxSubarrayXOR(int arr[], int n){
        int index = 0;
        for(int i=24; i>=0; i--){
            // max element with i'th bit set
            int max = -1, maxIndex=index;
            for(int j=index; j<n; j++) {
                if((arr[j]&(1<<i)) != 0 && max < arr[j]){
                    max = arr[j];
                    maxIndex = j;
                }
            }
            if(max == -1) continue;
            // swap index and maxIndex
            int tmp = arr[index];
            arr[index] = arr[maxIndex];
            arr[maxIndex] = tmp;
            
            // xor max with all element with i'th bit set
            for(int j=0; j<n; j++) {
                if((arr[j]&(1<<i)) != 0 && j != index)
                    arr[j] ^= max;
            }
            index++;
        }
        int ans = 0;
        for(int i : arr)
            ans ^= i;
        return ans;
    }
}