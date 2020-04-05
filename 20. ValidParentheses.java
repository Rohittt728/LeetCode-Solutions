/*

Link : https://leetcode.com/problems/valid-parentheses/

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:
Input: "()"
Output: true

Example 2:
Input: "()[]{}"
Output: true

Example 3:
Input: "(]"
Output: false

Example 4:
Input: "([)]"
Output: false

Example 5:
Input: "{[]}"
Output: true

*/


class Solution {

    // Stack Implementation
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int l = s.length();
        for (int i = 0; i < l; i++) {
            char c = s.charAt(i);
            if (c == ')' && !st.isEmpty() && st.peek() == '(') {
                st.pop();
            }
            else if (c == '}' && !st.isEmpty() && st.peek() == '{') {
                st.pop();
            }
            else if (c == ']' && !st.isEmpty() && st.peek() == '[') {
                st.pop();
            }
            else {
                st.push(c);
            }
        }
        if (st.isEmpty())
            return true;
        return false;
    }
}