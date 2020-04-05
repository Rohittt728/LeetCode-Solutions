/*

Link : https://leetcode.com/problems/single-number/

Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:
Input: [2,2,1]
Output: 1

Example 2:
Input: [4,1,2,1,2]
Output: 4

*/

class Solution {
    public int singleNumber(int[] nums) {
        int p = 0;
        for (int i : nums)          // XOR of two Numbers (0 ^ 1 = 1) (1 ^ 1 = 0)
            p = p ^ i;              // so all duplicate numbers get cancelled and single number remains
        return p;
    }
}