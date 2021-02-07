/*

Link : https://leetcode.com/problems/shortest-distance-to-a-character/

Given a string s and a character c that occurs in s, return an array of integers answer where answer.length == s.length and answer[i] is the shortest distance from s[i] to the character c in s.

Example 1:
Input: s = "loveleetcode", c = "e"
Output: [3,2,1,0,1,0,0,1,2,2,1,0]

Example 2:
Input: s = "aaab", c = "b"
Output: [3,2,1,0]

Constraints:
1 <= s.length <= 104
s[i] and c are lowercase English letters.
c occurs at least once in s.

*/


class Solution {
    public int[] shortestToChar(String s, char c) {
        
        int len = s.length();
        int ans[] = new int[len];
        int last = Integer.MIN_VALUE / 2;
        
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == c)
                last = i;
            ans[i] = i - last;
        }
        
        last = Integer.MAX_VALUE / 2;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == c)
                last = i;
            ans[i] = Math.min(ans[i], last - i);
        }
        
        return ans;
    }
}