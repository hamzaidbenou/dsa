package tree;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> nodes = new ArrayList<>();

    /**
     * Given a preorder traversal of a BST, find the leaf nodes of the tree without building the tree.
     * @param arr
     * @param N
     * @return
     */
    public int[] leafNodes(int arr[], int N){
        leafNodes(arr, 0, N-1);
        int[] ans = new int[nodes.size()];
        for(int i=0; i<ans.length; i++) ans[i] = nodes.get(i);
        return ans;
    }
    
    public void leafNodes(int arr[], int l, int r){
        if(l>r) return;
        if(l==r) nodes.add(arr[l]);
        
        int pos = search(arr, l+1, r, arr[l]);
        leafNodes(arr, l+1, pos);
        leafNodes(arr, pos+1, r);
    }
    
    public int search(int[] arr, int l, int r, int t) {
        while(l<=r) {
            int mid = l+(r-l)/2;
            if(arr[mid] >= t) r=mid-1;
            else l=mid+1;
        }
        return r;
    }
}