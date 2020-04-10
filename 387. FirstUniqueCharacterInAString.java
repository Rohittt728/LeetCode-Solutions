/*

Link : https://leetcode.com/problems/first-unique-character-in-a-string/

Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Example 1:
s = "leetcode"
return 0.

Example 2:
s = "loveleetcode",
return 2.

Note: You may assume the string contain only lowercase letters.

*/


class Solution {
    public int firstUniqChar(String s) {
        int l = s.length();
        int count[] = new int[26];
        Arrays.fill(count, 0);
        for (int i = 0; i < l; i++) {
            count[s.charAt(i) - 'a']++;         // Taking count of characters
        }
        
        for (int i = 0; i < l; i++) {
            if (count[s.charAt(i) - 'a'] == 1)  // Find character with count 1
                return i;
        }
        return -1;
    }
}