/*

Link : https://leetcode.com/problems/minimum-window-substring/

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:
Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"

Note:
If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.

*/



class Solution {
    public String minWindow(String s, String t) {
        
        if (s == null || s.length() == 0 || t.length() == 0 || s.length() < t.length())
            return "";
        
        HashMap<Character, Integer> h = new HashMap<Character, Integer>();
        int tlen = t.length();
        for (int i = 0; i < tlen; i++) {
            char c = t.charAt(i);
            h.put(c, h.getOrDefault(c, 0) + 1);
        }
        
        int slen = s.length();
        int left = 0;
        int minleft = 0;
        int minlen = slen + 1;
        int count = 0;
        
        for (int i = 0; i < slen; i++) {
            char c = s.charAt(i);
            
            if (h.containsKey(c)) {
                h.put(c, h.get(c) - 1);
                if (h.get(c) >= 0)
                    count ++;
                
                while (count == tlen) {
                    if (i - left + 1 < minlen) {
                        minleft = left;
                        minlen = i - left + 1;
                    }
                    
                    char lc = s.charAt(left);
                    if (h.containsKey(lc)) {
                        h.put(lc, h.get(lc) + 1);
                        if (h.get(lc) > 0)
                            count --;
                    }
                    left ++;
                }
            }
        }
        
        return (minlen > slen) ? "" : s.substring(minleft, minlen + minleft);
    }
}