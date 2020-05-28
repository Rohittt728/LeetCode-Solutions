/*

Link : https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/

Given a string S, find the length of the longest substring T that contains at most k distinct characters.

Example 1:
Input: S = "eceba" and k = 3
Output: 4
Explanation: T = "eceb"

Example 2:
Input: S = "WORLD" and k = 4
Output: 4
Explanation: T = "WORL" or "ORLD"

*/


public class Solution {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        
        HashMap<Character, Integer> h = new HashMap<Character, Integer>();
        int max = 0;
        int start = 0;
        int len = s.length();
        
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            h.put(c, h.getOrDefault(c, 0) + 1);
            
            if (h.size() <= k)
                max = Math.max(max, i - start + 1);
            else {
                while (h.size() > k) {
                    char sc = s.charAt(start);
                    int val = h.get(sc);
                    if (val == 1)
                        h.remove(sc);
                    else
                        h.put(sc, h.get(sc) - 1);
                    start ++;
                }
            }
        }
        return max;
    }
}