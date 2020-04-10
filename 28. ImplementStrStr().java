/*

Link : https://leetcode.com/problems/implement-strstr/

Implement strStr().
Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:
Input: haystack = "hello", needle = "ll"
Output: 2

Example 2:
Input: haystack = "aaaaa", needle = "bba"
Output: -1

Clarification:
What should we return when needle is an empty string? This is a great question to ask during an interview.
For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

*/

class Solution {
    public int strStr(String haystack, String needle) {
        
        // base case
        if (haystack == null || needle == null)
            return 0;
        
        int l = needle.length();
        int n = haystack.length();
        
        if (l > n)
            return -1;
        if (l == 0)
            return 0;
        
        // longest proper prefix which is also suffix : array
        int lps[] = new int[l];
        computeLpsArray (needle, lps, l);
        
        int j = 0;  // needle pointer
        int i = 0;  // haystack pointer

        while (i < n) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i ++;
                j ++;
            }

            // reached needle's end, hence needle found
            if (j == l)
                break;

            // handling mismatch of needle char and haystack char
            if (i < n && haystack.charAt(i) != needle.charAt(j)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i ++;
            }
        }
        if (j == l)
            return i - j;
        return -1;
    }
    
    public void computeLpsArray (String s, int lps[], int len) {
        lps[0] = 0;
        for (int i = 1; i < len; i++) {
            int j = lps[i - 1];
            
            while (j > 0 && s.charAt(j) != s.charAt(i))
                j = lps[j - 1];
            
            if (s.charAt(i) == s.charAt(j))
                lps[i] = j + 1;
            else
                lps[i] = 0;
        }
    }
}