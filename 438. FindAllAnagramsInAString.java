/*

Link : https://leetcode.com/problems/find-all-anagrams-in-a-string/

Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:
Input:
s: "cbaebabacd" p: "abc"
Output:
[0, 6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".


Example 2:
Input:
s: "abab" p: "ab"
Output:
[0, 1, 2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

*/



// Sliding window approach
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> ans = new ArrayList<Integer>();
        if (s == null || s.length() == 0)
            return ans;
        
        int char_count[] = new int[26];
        int plen = p.length();
        
        for (int i = 0; i < plen; i++) {
            char_count[p.charAt(i) - 'a']++;
        }
        
        int slen = s.length();
        int left = 0;
        int right = 0;
        int count = plen;
        
        while (right < slen) {
            
            if (char_count[s.charAt(right++) - 'a']-- > 0)
                count --;
            
            if (count == 0)
                ans.add(left);
            
            if (right - left == plen && char_count[s.charAt(left++) - 'a']++ >= 0)
                count ++;
        }
        return ans;
    }
}