/*

Link : https://leetcode.com/problems/partition-labels/

A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.

Note:
S will have length in range [1, 500].
S will consist of lowercase English letters ('a' to 'z') only.

*/


class Solution {
    public List<Integer> partitionLabels(String S) {
        
        int len = S.length();
        int map[] = new int[26];
        
        List<Integer> ans = new ArrayList<>();
        
        for (int i = 0; i < len; i++) {
            char c = S.charAt(i);
            map[c - 'a'] = i;
        }
        
        int start = 0;
        int last = 0;
        for (int i = 0; i < len; i++) {
            char c = S.charAt(i);
            last = Math.max(last, map[c - 'a']);
            
            if (last == i) {
                ans.add(last - start + 1);
                start = last + 1;
            }
        }
        return ans;
    }
}