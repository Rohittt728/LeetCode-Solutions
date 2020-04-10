/*

Link : https://leetcode.com/problems/longest-common-prefix/

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:
Input: ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Note:
All given inputs are in lowercase letters a-z.

*/


class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null)
            return "";
        int l = strs.length;
        if (l == 0)
            return "";
        if (l == 1)
            return strs[0];
        String ans = strs[0];
        for (int i = 1; i < l; i++) {
            ans = longestCommonPrefixBetweenTwoStrings(ans, strs[i]);
        }
        return ans;
    }
    
    // Comparing two strings
    public String longestCommonPrefixBetweenTwoStrings(String str1, String str2) {
        int l = Math.min(str1.length(), str2.length());
        String res = "";
        for (int i = 0; i < l; i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            if (c1 != c2)
                break;
            res += c1;
        }
        return res;
    }
}