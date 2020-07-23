/*

Link : https://leetcode.com/problems/single-number-iii/

Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

Example:
Input:  [1,2,1,3,2,5]
Output: [3,5]

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?

*/



class Solution {
    public int[] singleNumber(int[] nums) {
        
        int ans[] = new int[2];
        
        // finding a^b
        int xor = 0;
        for (int i : nums)
            xor = xor ^ i;
        
        // Finding any arbitrary set bit
        xor &= -xor;
        
        // dividing into two groups on the basis of this set bit
        for (int i : nums) {
            if ((i & xor) == 0)
                ans[0] ^= i;
            else
                ans[1] ^= i;
        }
        
        return ans;
    }
}