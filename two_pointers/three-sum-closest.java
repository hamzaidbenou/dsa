package two_pointers;

import java.util.Arrays;

class Solution {

    /**
     * Given an array, Arr of N numbers, and another number target, find three integers in the array such that 
     * the sum is closest to the target. Return the sum of the three integers.
     * Note: If there are multiple solutions, print the maximum one.
     * @param nums
     * @param target
     * @return
     */
    static int threeSumClosest(int[] nums, int target){ 
        Arrays.sort(nums);
        int diff=Integer.MAX_VALUE, ans=Integer.MIN_VALUE, n=nums.length;
        for(int i=0; i<n; i++) {
            if(i>0 && nums[i]==nums[i-1]) continue;
            int l=i+1, r=n-1, sum=target-nums[i];
            while(l<r) {
                if(nums[l]+nums[r]==sum) {
                    return target;
                } else {
                    if(diff > Math.abs(nums[l]+nums[r]-sum)) {
                        diff = Math.abs(nums[l]+nums[r]-sum);
                        ans = nums[i]+nums[l]+nums[r];
                    } else {
                        if(diff == Math.abs(nums[l]+nums[r]-sum)) {
                            ans = Math.max(ans, nums[i]+nums[l]+nums[r]);
                        }
                    }
                    if(nums[l]+nums[r]<sum) l++;
                    else r--;
                }
            }
        }
        return ans;
	} 
}
