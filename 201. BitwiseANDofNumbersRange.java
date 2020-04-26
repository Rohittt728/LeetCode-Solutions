/*

Link : https://leetcode.com/problems/bitwise-and-of-numbers-range/

Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

Example 1:
Input: [5,7]
Output: 4

Example 2:
Input: [0,1]
Output: 0

*/


// Solution 1
class Solution {

	// Bitwise AND of 2 numbers will result in a number less than or equal to the smaller one
    public int rangeBitwiseAnd(int m, int n) {
        
        while (n > m)
            n = n & (n - 1);
        
        return m & n;
    }
}



// Solution 2
class Solution {
	// we see that
	// moving from rightmost bit to left for both m & n
	// we eliminate these bits and check if m & n are equal
	// based on the obervation that if at some point m equals n
	// the after that point every right bit will be flipped atleast once and result in a 0
	// meanwhile keeping track of the movement from right to left as a count
	// and answer becomes the number left shifted this count times
    public int rangeBitwiseAnd(int m, int n) {
        
        int count = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            count ++;
        }
        return n << count;
    }
}


// Solution1 & Solution2, both are based on the same base logic as explained in Solution2 comments.