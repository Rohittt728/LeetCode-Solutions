/*

Link : https://leetcode.com/problems/valid-anagram/

Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?

*/


class Solution {
    public boolean isAnagram(String s, String t) {
        int l1 = s.length();
        int l2 = t.length();
        if (l1 != l2)
            return false;
        
        int count[] = new int[26];
        Arrays.fill(count, 0);
        
        for (int i = 0; i < l1; i++) {      // incrementing & decrementing char counts for both strings
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        
        for (int i = 0; i < 26; i++) {      // if anagrams, then all char counts will be 0
            if (count[i] != 0)
                return false;
        }
        return true;
    }
}

/*

Follow up:
1. What if the inputs contain unicode characters? How would you adapt your solution to such case?
-- Use HashTable instead of a fixed size count array. Since number of unicode characters could go upto 1 million, so hashtable would be a more generic solution.

*/