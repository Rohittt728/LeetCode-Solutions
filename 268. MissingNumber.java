/*

Link : https://leetcode.com/problems/missing-number/

Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:
Input: [3,0,1]
Output: 2

Example 2:
Input: [9,6,4,2,3,5,7,0,1]
Output: 8

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

*/


// Using Bit Manipulation, XOR of two numbers (a ^ 0 = a, a ^ a = 0)
class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans ^= (i+1) ^ nums[i];
        }
        return ans;
    }
}