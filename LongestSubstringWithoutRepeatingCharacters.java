/*

Link : https://leetcode.com/problems/longest-substring-without-repeating-characters/

Given a string, find the length of the longest substring without repeating characters.

Example 1:
Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 

Example 2:
Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = s.length();
        Map<Character, Integer> h = new HashMap<>();    // to store character and its latest index
        int j = 0;
        int ans = 0;                                    // to store maximum length
        for (int i = 0; i < l; i++) {
            char c = s.charAt(i);
            if (h.containsKey(c)) {             // if character repeated
                j = Math.max (h.get(c), j);     // move to previous charcter index + 1
            }
            ans = Math.max (ans, i - j + 1);    // maximum length found so far
            h.put (c, i + 1);                   // (i+1); if repetition found then will move to previous repetition + 1
        }
        return ans;
    }
}