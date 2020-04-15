/*

Link : https://leetcode.com/problems/power-of-three/

Given an integer, write a function to determine if it is a power of three.

Example 1:
Input: 27
Output: true

Example 2:
Input: 0
Output: false

Example 3:
Input: 9
Output: true

Example 4:
Input: 45
Output: false

Follow up:
-- Could you do it without using any loop / recursion?

*/


// Solution1 : Brute Force
class Solution {
    public boolean isPowerOfThree(int n) {
        
        if (n == 0)
            return false;
        
        while (n % 3 == 0)
            n = n /3;
        
        return n == 1;
    }
}



// Solution2 : Converting base to 3, then checking if the number contains a single set bit followed by all zeroes
class Solution {
    public boolean isPowerOfThree(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }
}



// Solution3 : using max value
class Solution {
	// Integer max = 2147483647, greatest power of 3 <= max is 3^19 = 1162261467
	// using this number directly
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}



/*

Follow up:
1. Could you do it without using any loop / recursion?
-- Refer Solution 2 & 3

*/