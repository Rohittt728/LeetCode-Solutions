/*

Link : https://leetcode.com/problems/divide-two-integers/

Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero, which means losing its fractional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.

Example 1:
Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = truncate(3.33333..) = 3.

Example 2:
Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = truncate(-2.33333..) = -2.

Note:
Both dividend and divisor will be 32-bit signed integers.
The divisor will never be 0.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.

*/


class Solution {
    public int divide(int dividend, int divisor) {
        
        // edge cases
        if (divisor == 0)
            return Integer.MAX_VALUE;
        if (divisor == -1 && dividend == Integer.MIN_VALUE)
            return Integer.MAX_VALUE;
        
        // decide sign
        boolean isPositive = true;
        if ((divisor < 0) ^ (dividend < 0))
            isPositive = false;
        
        // using long to handle cases like, dividend = INT_MIN, divisor = 1
        long divid = Math.abs((long)dividend);
        long divis = Math.abs((long)divisor);
        
        int ans = 0;
        while (divid >= divis) {
            
            // counting left shifts
            int shifts = 0;
            while (divid >= (divis << shifts))
                shifts ++;
            
            ans += (1 << (shifts - 1));

            // dividend minus the largest shifted divisor
            divid -= (divis << (shifts - 1));
        }

        // return answer alongwith sign
        if (isPositive)
            return ans;
        return -ans;
    }
}