/*

Link : https://leetcode.com/problems/longest-palindromic-substring/

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:
Input: "cbbd"
Output: "bb"

*/

class Solution {

    // Dynamic Programming Solution
    public String longestPalindrome(String s) {
        if (s == null || s.equals(""))      // empty or null check
            return s;
        int l = s.length();
        if (l == 1)                         // single character is a palindrome
            return s;
        
        boolean dp[][] = new boolean[l][l]; // DP array
        for (int i = 0; i < l; i++) {       
            dp[i][i] = true;
        }
        
        int max = 1;                        // length of palindromic substring
        int start_index = 0;                // store starting index of palindromic substring
        for (int k = 2; k <= l; k++) {                  // length of substring iteration
            int len = 0;
            for (int i = 0; i < l - k + 1; i++) {       // check each substring of fixed length
                int j = i + k - 1;
                char ci = s.charAt(i);
                char cj = s.charAt(j);
                if (k == 2) {                           // special case for length 2 substrings
                    if (ci == cj) {
                        dp[i][j] = true;
                        len = 2;
                        start_index = i;
                    }
                }
                else {
                    if (dp[i+1][j-1] && ci == cj) {
                        dp[i][j] = true;
                        len = k;
                        start_index = i;
                    }
                }
                if (len > max)
                    max = len;
            }
        }
        return s.substring(start_index, start_index + max);
    }
}
