/*

Link : https://leetcode.com/problems/power-of-four/

Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example 1:
Input: 16
Output: true

Example 2:
Input: 5
Output: false

Follow up: Could you solve it without loops/recursion?

*/



// Solution 1
// 0x55555555 is a hexametrical number，it is 1010101010101010101010101010101 in binary with a length of 32. To make sure the 1 locates in the odd location.
class Solution {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
    }
}