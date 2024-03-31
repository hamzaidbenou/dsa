package sorting;

class Solution {
    int[] ans;

    /**
     * Given an array Arr of size N containing positive integers.
     * Count number of smaller elements on right side of each array element.
     * @param arr
     * @param n
     * @return
     */
    int[] constructLowerArray(int[] arr, int n) {
        ans = new int[n];
        int[][] nums = new int[n][2];
        for(int i=0; i<n; i++) {
            nums[i][0] = arr[i];
            nums[i][1] = i;
        }
        mergeSortAndCount(nums, 0, n-1);
        return ans;
    }

    public void mergeSortAndCount(int[][] arr, int l, int r) {
        if(l < r){
            int mid = l + (r-l)/2;
            mergeSortAndCount(arr, l, mid);
            mergeSortAndCount(arr, mid+1, r);
            
            mergeSort(arr, l, mid, r);
        }
    }
    
    public void mergeSort(int[][] arr, int l, int m, int r){
        int[][] left = copy(arr, l, m+1);
        int[][] right = copy(arr, m+1, r+1);
        int i=0, j=0, k=l;
        
        while(i<left.length && j<right.length) {
            if(left[i][0] <= right[j][0]) {
                ans[left[i][1]] += j;
                update(arr, k++, left, i++);
            }
            else {
                update(arr, k++, right, j++);
            }
        }
        while(j<right.length) update(arr, k++, right, j++);
        while(i<left.length) {
            ans[left[i][1]] += j;
            update(arr, k++, left, i++);
        }
    }
    
    public int[][] copy(int[][] arr, int start, int end) {
        int[][] nums = new int[end-start][2];
        for(int i=0; i<end-start; i++) {
            nums[i][0] = arr[start+i][0];
            nums[i][1] = arr[start+i][1];
        }
        return nums;
    }
    
    public void update(int[][] arr, int k, int[][] left, int i) {
        arr[k][0]=left[i][0];
        arr[k][1]=left[i][1];
    }
}
