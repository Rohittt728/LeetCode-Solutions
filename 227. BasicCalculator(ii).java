/*

Link : https://leetcode.com/problems/basic-calculator-ii/

Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

Example 1:
Input: "3+2*2"
Output: 7

Example 2:
Input: " 3/2 "
Output: 1

Example 3:
Input: " 3+5 / 2 "
Output: 5

Note:
You may assume that the given expression is always valid.
Do not use the eval built-in library function.

*/


class Solution {
    public int calculate(String s) {
        
        int len = s.length();
        int pre = 0;
        int curr = 0;
        char sign = '+';
        int ans = 0;
        int i = 0;
        
        while (i < len) {
            
            while (i < len && s.charAt(i) == ' ')
                i++;
            
            curr = 0;
            while (i < len && Character.isDigit(s.charAt(i)))
                curr = curr * 10 + (s.charAt(i++) - '0');
            
            if (sign == '+') {
                ans += pre;
                pre = curr;
            }
            
            else if (sign == '-') {
                ans += pre;
                pre = -curr;
            }
            
            else if (sign == '*')
                pre = pre * curr;
            
            else if (sign == '/')
                pre = pre / curr;
            
            while (i < len && s.charAt(i) == ' ')
                i++;
            
            if (i < len)
                sign = s.charAt(i++);
        }
        ans += pre;
        return ans;
    }
}