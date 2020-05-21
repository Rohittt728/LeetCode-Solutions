/*

Link : https://leetcode.com/problems/first-missing-positive/

Given an unsorted integer array, find the smallest missing positive integer.

Example 1:
Input: [1,2,0]
Output: 3

Example 2:
Input: [3,4,-1,1]
Output: 2

Example 3:
Input: [7,8,9,11,12]
Output: 1

Note:
Your algorithm should run in O(n) time and uses constant extra space.

*/



class Solution {
    public int firstMissingPositive(int[] nums) {
        
        int len = nums.length;
        
        for (int i = 0; i < len; i++) {
            
            while (nums[i] != i + 1) {
                
                if (nums[i] > len || nums[i] <= 0)
                    break;
                
                if (nums[i] == nums[nums[i] - 1])
                    break;
                
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
        
        for (int i = 1; i <= len; i++) {
            if (nums[i - 1] != i)
                return i;
        }
        return len + 1;
    }
}