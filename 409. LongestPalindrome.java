/*

Link : https://leetcode.com/problems/longest-palindrome/

Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:
Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.

*/



class Solution {
    public int longestPalindrome(String s) {
        
        int len = s.length();
        
        int ans = 0;
        HashSet<Character> h = new HashSet<Character>();
        
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            
            if (h.contains(c)) {
                h.remove(c);
                ans ++;
            }
            else
                h.add(c);
        }
        
        return (h.isEmpty()) ? ans * 2 : ans * 2 + 1; 
    }
}