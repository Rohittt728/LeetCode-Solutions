/*

Link : https://leetcode.com/problems/permutation-in-string/

Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.

Example 1:
Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:
Input:s1= "ab" s2 = "eidboaoo"
Output: False

Note:
The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].

*/



class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if (s2 == null || s2.length() == 0)
            return false;
        
        int s1len = s1.length();
        int char_count[] = new int[26];
        for (int i = 0; i < s1len; i++) {
            char_count[s1.charAt(i) - 'a'] ++;
        }
        
        int s2len = s2.length();
        int left = 0;
        int right = 0;
        int count = s1len;
        
        while (right < s2len) {
            
            if (char_count[s2.charAt(right++) - 'a']-- > 0)
                count --;
            
            if (count == 0)
                return true;
            
            if (right - left == s1len && char_count[s2.charAt(left++) - 'a']++ >= 0)
                count ++;
        }
        return false;
    }
}