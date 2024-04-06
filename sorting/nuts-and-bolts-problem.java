package sorting;

class Solution {

    /**
     * Given a set of N nuts of different sizes and N bolts of different sizes.
     * There is a one-one mapping between nuts and bolts. Match nuts and bolts efficiently.
     * Comparison of a nut to another nut or a bolt to another bolt is not allowed. It means nut 
     * can only be compared with bolt and bolt can only be compared with nut to see which one is 
     * bigger/smaller. The elements should follow the following order ! # $ % & * @ ^ ~ .
     * @param nuts
     * @param bolts
     * @param n
     */
    void matchPairs(char nuts[], char bolts[], int n) {
        matchPairs(nuts, bolts, 0, n-1);
    }
    
    void matchPairs(char nuts[], char bolts[], int low, int high) {
        if(low >= high) return ;
        int pivot = partition(nuts, low, high, bolts[high]);
        partition(bolts, low, high, nuts[pivot]);
        matchPairs(nuts, bolts, low, pivot-1);
        matchPairs(nuts, bolts, pivot+1, high);
    }
    
    int partition(char[] arr, int low, int high, char pivot){
        int i = low;
        for (int j = low; j < high; j++){
            if (arr[j] < pivot){
                swap(arr, i++, j);
            } else if(arr[j] == pivot){
                swap(arr, j--, high);
            }
        }
        swap(arr, i, high);

        return i;
    }

    void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}