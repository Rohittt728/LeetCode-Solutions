/*

Link : https://leetcode.com/problems/single-number-ii/

Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:
Input: [2,2,3,2]
Output: 3

Example 2:
Input: [0,1,0,1,0,1,99]
Output: 99

*/


// Solution 1 : O (32 * n)
class Solution {
    public int singleNumber(int[] nums) {
        
        int ans = 0;
        
        for (int i = 0; i < 32; i++) {
            
            int set_bits = 0;
            for (int n : nums) {
                if (((n >> i) & 1) == 1)
                    set_bits ++;
            }
            
            set_bits %= 3;
            
            if (set_bits == 1)
                ans = ans | (set_bits << i);
        }
        
        return ans;
    }
}



// Solution 2 : Not intuitive
class Solution {
    public int singleNumber(int[] nums) {
        
        int ones = 0;
        int twos = 0;
        // int thrice = 0;
        
        for (int n : nums) {
            
            // twos = twos | (ones & n);
            // ones = ones ^ n;
            // thrice = ones & twos;
            // ones &= ~thrice;
            // twos &= ~thrice;
            
            ones = (ones ^ n) & ~twos;
            twos = (twos ^ n) & ~ones;
        }
        
        return ones;
    }
}