/*

Link : https://leetcode.com/problems/excel-sheet-column-number/

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...

Example 1:
Input: "A"
Output: 1

Example 2:
Input: "AB"
Output: 28

Example 3:
Input: "ZY"
Output: 701

*/


class Solution {
    public int titleToNumber(String s) {
        
        int p = 1;
        int ans = 0;
        int len = s.length();
        
        for (int i = len - 1; i >= 0; i--) {
            int c = s.charAt(i) - 'A' + 1;
            ans += p * c;
            p *= 26;
        }
        return ans;
    }
}