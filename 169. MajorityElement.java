/*

Link : https://leetcode.com/problems/majority-element/

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:
Input: [3,2,3]
Output: 3

Example 2:
Input: [2,2,1,1,1,2,2]
Output: 2

*/



// Boyer Moore Voting Algorithm
class Solution {
    public int majorityElement(int[] nums) {
        
        int count = 0;
        int curr = 0;
        
        for (int i : nums) {
            if (count == 0)
                curr = i;
            count += (i == curr) ? 1 : -1;
        }
        return curr;
    }
}