/*

Link : https://leetcode.com/problems/valid-parenthesis-string/

Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

1. Any left parenthesis '(' must have a corresponding right parenthesis ')'.
2. Any right parenthesis ')' must have a corresponding left parenthesis '('.
3. Left parenthesis '(' must go before the corresponding right parenthesis ')'.
4. '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
5. An empty string is also valid.

Example 1:
Input: "()"
Output: True

Example 2:
Input: "(*)"
Output: True

Example 3:
Input: "(*))"
Output: True

Note:
The string size will be in the range [1, 100].

*/



class Solution {
    public boolean checkValidString(String s) {
        
        int len = s.length();
        
        if (len == 0)
            return true;
        
        int low = 0;
        int high = 0;
        
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            low += (c == '(') ? 1 : -1;
            high += (c != ')') ? 1 : -1;
            if (high < 0)
                break;
            low = (low > 0) ? low : 0;
        }
        
        return low == 0;
    }
}