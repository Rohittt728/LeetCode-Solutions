/*

Link : https://leetcode.com/problems/backspace-string-compare/

Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:
Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".

Example 2:
Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".

Example 3:
Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".

Example 4:
Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".

Note:
1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.

Follow up:
Can you solve it in O(N) time and O(1) space?

*/


// Solution1 : separately build each string then compare
class Solution {
    public boolean backspaceCompare(String s, String t) {
        return buildString(s).equals(buildString(t));
    }
    
    public String buildString (String s) {
        Stack<Character> st = new Stack<Character>();
        char arr[] = s.toCharArray();
        for (char c : arr) {
            if (c != '#')
                st.push(c);
            else if (!st.isEmpty())
                st.pop();
        }
        return String.valueOf(st);
    }
}


// Solution2 : two pointer approach in single pass
class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int skipi = 0, skipj = 0;
        
        while (i >= 0 || j >= 0) {
            
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipi ++;
                    i --;
                }
                else if (skipi > 0) {
                    skipi --;
                    i --;
                }
                else
                    break;
            }
            
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipj ++;
                    j --;
                }
                else if (skipj > 0) {
                    skipj --;
                    j --;
                }
                else
                    break;
            }
            if (i < 0 && j < 0)
                return true;
            if (i < 0 || j < 0)
                return false;
            if (s.charAt(i) != t.charAt(j))
                return false;
            i--;
            j--;
        }
        return true;
    }
}


/*

Follow up:
1. Can you solve it in O(N) time and O(1) space?
-- Refer to Solution2 above.

*/