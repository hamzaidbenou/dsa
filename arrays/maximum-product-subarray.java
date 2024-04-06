package arrays;

class Solution {
    
    // Function to find maximum product subarray
    long maxProduct(int[] nums, int n) {
        int prev = 0;
        long ans = 1L*nums[0];
        for(int i = 0; i < n; i++) {
            if(nums[i] == 0) {
                ans = Math.max(ans, 0);
                ans = Math.max(ans, help(nums, prev, i - 1));
                prev = i + 1;
            }
        }
        if(nums[n - 1] != 0) {
            ans = Math.max(ans, help(nums,  prev, n - 1));
        }
        return ans;
    }
    
    long help(int[] nums, int start, int end) {
        if(start > end) return 0L;
        if(start == end) return 1L*nums[start];
        long cumul=1L, left=1L, right=1L;
        int count=0;
        for(int i=start; i<=end; i++) {
            if(nums[i] < 0) {
                count++;
                right = 1L;
            }
            cumul *= 1L*nums[i];
            right *= 1L*nums[i];
            if(left > 0) left *= 1L*nums[i];
        }
        if(count%2== 0) return cumul;
        else return Math.max(cumul/left, cumul/right);
    }
}
