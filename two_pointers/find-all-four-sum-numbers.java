package two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<ArrayList<Integer>> res = new ArrayList<>();

    /**
     * Given an array A of integers and another number K. Find all the unique quadruple from the given array that sums up to K.
     * Also note that all the quadruples which you return should be internally sorted, ie for any quadruple [q1, q2, q3, q4] 
     * the following should follow: q1 <= q2 <= q3 <= q4.
     * @param nums
     * @param target
     * @return
     */
    public List<ArrayList<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++) {
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1; j<nums.length; j++) {
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int l=j+1, r=nums.length-1, sum=target-nums[i]-nums[j];
                while(l<r) {
                    if(nums[l]+nums[r]==sum) {
                        res.add(new ArrayList<>(List.of(nums[i],nums[j],nums[l++],nums[r--])));
                        while(l<r && nums[l-1]==nums[l]) l++;
                    } else {
                        if(nums[l]+nums[r]<sum) l++;
                        else r--;
                    }
                }
                
            }
        }
        return res;
    }
}