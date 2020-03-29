/*

Link : https://leetcode.com/problems/zigzag-conversion/

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);

Example 1:
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

Example 2:
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I

*/

class Solution {
    public String convert(String s, int numRows) {
        int l = s.length();
        if (numRows == 1 || numRows >= l)
            return s;
        
        int j = 0;
        boolean f = true;
        String st[] = new String[numRows];          // store string formed at each row
        Arrays.fill(st, "");
        
        String ans = "";                            // final string
        
        for (int i = 0; i < l; i++) {
            st[j] = st[j] + s.charAt(i);        // append to corresponding row
            if (f)
                j ++;
            else
                j --;
            if (j == numRows - 1 || j == 0)     // change row iteration direction on first & last row
                f = !f;
        }
        for (int i = 0; i < numRows; i++) {
            ans = ans + st[i];                  // making final string
        }
        return ans;
    }
}