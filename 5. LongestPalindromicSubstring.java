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


// Solution1 : DP
class Solution {

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
            for (int i = 0; i < l - k + 1; i++) {       // check each substring of fixed length
                int j = i + k - 1;
                char ci = s.charAt(i);
                char cj = s.charAt(j);
                if (k == 2) {                           // special case for length 2 substrings
                    if (ci == cj) {
                        dp[i][j] = true;
                        max = 2;
                        start_index = i;
                    }
                }
                else {
                    if (dp[i+1][j-1] && ci == cj) {
                        dp[i][j] = true;
                        max = k;
                        start_index = i;
                    }
                }
            }
        }
        return s.substring(start_index, start_index + max);
    }
}




// Solution2 : Expand around center
class Solution {
    public String longestPalindrome(String s) {
        
        int len = s.length();
        if (len == 0 || len == 1)
            return s;
        
        int max = 1;
        int start = 0;
        
        int low, high;
        for (int i = 1; i < len; i++) {
            
            // longest even length palindrome with center as i-1 and i
            low = i - 1;
            high = i;
            while (low >= 0 && high < len && s.charAt(low) == s.charAt(high)) {
                if ((high - low + 1) > max) {
                    max = high - low + 1;
                    start = low;
                }
                low --;
                high ++;
            }
            
            // longest odd length palindrome with center as i
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < len && s.charAt(low) == s.charAt(high)) {
                if ((high - low + 1) > max) {
                    max = high - low + 1;
                    start = low;
                }
                low --;
                high ++;
            }
        }
        return s.substring(start, start + max);
    }
}
