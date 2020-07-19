/*

Link : https://leetcode.com/problems/add-binary/

Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:
Input: a = "11", b = "1"
Output: "100"

Example 2:
Input: a = "1010", b = "1011"
Output: "10101"

Constraints:
Each string consists only of '0' or '1' characters.
1 <= a.length, b.length <= 10^4
Each string is either "0" or doesn't contain any leading zero.

*/



// Solution 1
class Solution {
    public String addBinary(String a, String b) {
        
        String ans = "";
        
        int al = a.length();
        int bl = b.length();
        
        int i = al - 1;
        int j = bl - 1;
        char c = '0';
        
        while (i >= 0 && j >= 0) {
            char c1 = a.charAt(i);
            char c2 = b.charAt(j);
            char curr;
            
            if (c1 == '1' && c2 == '1') {
                if (c == '1')
                    curr = '1';
                else
                    curr = '0';
                c = '1';
            }
            else if (c1 == '1' || c2 == '1') {
                if (c == '1') {
                    curr = '0';
                    c = '1';
                }
                else {
                    curr = '1';
                    c = '0';
                }
            }
            else {
                if (c == '1')
                    curr = '1';
                else
                    curr = '0';
                c = '0';
            }
            ans = curr + ans;
            i --;
            j --;
        }
        
        if (i == -1 && j == -1) {
            if (c == '1')
                ans = c + ans;
            return ans;
        }
        
        if (i == -1) {
            while (j >= 0) {
                char c2 = b.charAt(j);
                char curr;
                
                if (c2 == '1') {
                    if (c == '1') {
                        curr = '0';
                        c = '1';
                    }
                    else {
                        curr = '1';
                        c = '0';
                    }
                }
                else {
                    if (c == '1') {
                        curr = '1';
                        c = '0';
                    }
                    else {
                        curr = '0';
                        c = '0';
                    }
                }
                j --;
                ans = curr + ans;
            }
            if (c == '1')
                ans = c + ans;
            return ans;
        }
        
        if (j == -1) {
            while (i >= 0) {
                char c1 = a.charAt(i);
                char curr;
                
                if (c1 == '1') {
                    if (c == '1') {
                        curr = '0';
                        c = '1';
                    }
                    else {
                        curr = '1';
                        c = '0';
                    }
                }
                else {
                    if (c == '1') {
                        curr = '1';
                        c = '0';
                    }
                    else {
                        curr = '0';
                        c = '0';
                    }
                }
                i --;
                ans = curr + ans;
            }
            if (c == '1')
                ans = c + ans;
            return ans;
        }
        return null;
    }
}



// Solution 2
class Solution {
    public String addBinary(String a, String b) {
        
        String ans = "";
        
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0)
                sum += a.charAt(i--) - '0';
            if (j >= 0)
                sum += b.charAt(j--) - '0';
            
            ans = sum % 2 + ans;
            carry = sum / 2;
        }
        
        if (carry == 1)
            ans = carry + ans;
        return ans;
    }
}