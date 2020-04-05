/*

Link : https://leetcode.com/problems/reverse-integer/

Given a 32-bit signed integer, reverse digits of an integer.

Example 1:
Input: 123
Output: 321

Example 2:
Input: -123
Output: -321

Example 3:
Input: 120
Output: 21

Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range:
[−2^31,  2^31 − 1].
For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

*/

class Solution {
    public int reverse(int x) {
        int n = 0;
        int max = Integer.MAX_VALUE;			// Integer MAX last digit 7 and positive number
        int min = Integer.MIN_VALUE;			// Integer MIN last digit 8 and negative number
        while (x != 0) {						// going with reverse number logic
       	    int rem = x % 10;						// remainder (last digit)
	    x = x / 10;							// number except last digit
            if ((n > max / 10) || (n == max / 10 && rem > 7))		// will it overflow towards max?
		return 0;
            if ((n < min / 10) || (n == min / 10 && rem < -8))		// will it overflow towards min?
              	return 0;
            n = (n * 10) + rem;						// forming reverse number
        }
        return n;
    }
}
