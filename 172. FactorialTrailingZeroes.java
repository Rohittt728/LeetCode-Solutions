/*

Link : https://leetcode.com/problems/factorial-trailing-zeroes/

Given an integer n, return the number of trailing zeroes in n!.

Example 1:
Input: 3
Output: 0
Explanation: 3! = 6, no trailing zero.

Example 2:
Input: 5
Output: 1
Explanation: 5! = 120, one trailing zero.

Note: Your solution should be in logarithmic time complexity.

*/


class Solution {

	// every 0 we get (i.e. 10) is formed by 5 * 2
	// we obiviously have ample amount of 2's
	// so we just count the 5's
    public int trailingZeroes(int n) {
        
        int ans = 0;
        while (n > 0) {
            n = n / 5;
            ans += n;
        }
        
        return ans;
    }
}