package sorting;

/**
 * Quick Sort is a Divide and Conquer algorithm. It picks an element as a pivot and partitions the given 
 * array around the picked pivot. Given an array arr[], its starting position is low (the index of the array) 
 * and its ending position is high(the index of the array). Note: The low and high are inclusive.
 * Implement the partition() and quickSort() functions to sort the array.
 */
class Solution
{
    //Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high){
        int pivot;
        if(low < high){
            pivot = partition(arr, low, high);
            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);
        }
    }

    static int partition(int arr[], int low, int high){
        int tmp, lo=low, pivot=arr[high];
        for(int i=low; i<high; i++){
            if(pivot > arr[i]) {
                tmp = arr[lo];
                arr[lo++] = arr[i];
                arr[i] = tmp;
            }
        }
        tmp = arr[lo];
        arr[lo] = arr[high];
        arr[high] = tmp;
        return lo;
    } 
}
