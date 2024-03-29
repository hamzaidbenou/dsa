package sorting;

/**
 * Given an array of size N. The task is to sort the array elements by completing functions heapify() 
 * and buildHeap() which are used to implement Heap Sort.
 */
class Solution {

    void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //Function to build a Heap from array.
    void buildHeap(int arr[], int n){
        for(int i=n-1; i>=0; i--) heapify(arr, n, i);
    }
 
    //Heapify function to maintain heap property.
    void heapify(int arr[], int n, int i){
        int largest = i, left=2*i+1, right=left+1;
        if(left<n && arr[left] > arr[largest]) largest=left;
        if(right<n && arr[right] > arr[largest]) largest=right;
        if(largest != i){
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }
    
    //Function to sort an array using Heap Sort.
    public void heapSort(int arr[], int n){
        buildHeap(arr, n);
        int pos = n;
        for(int i=0; i<n; i++){
            heapify(arr, pos, 0);
            swap(arr, 0, --pos);
        }
        
    }
 }
