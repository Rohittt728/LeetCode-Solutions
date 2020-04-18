/*

Link : https://leetcode.com/problems/increasing-triplet-subsequence/

Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:
Return true if there exists i, j, k
such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.

Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.

Example 1:
Input: [1,2,3,4,5]
Output: true

Example 2:
Input: [5,4,3,2,1]
Output: false

*/


class Solution {
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        
        if (len < 3)			// base case
            return false;
        
        int first = Integer.MAX_VALUE;
        int second = first;
        
        for (int i = 0; i < len; i++) {
            
            if (nums[i] < first)						// minimum so far
                first = nums[i];
            
            if (nums[i] > first)						// second min so far
                second = Math.min(second, nums[i]);
            
            if (nums[i] > second)						// third min so far, hence triplet
                return true;
        }
        return false;
    }
}