/*

Link : https://leetcode.com/problems/detect-capital/

Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.

Example 1:
Input: "USA"
Output: True

Example 2:
Input: "FlaG"
Output: False

Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.

*/



class Solution {
    public boolean detectCapitalUse(String word) {
        
        int len = word.length();
        
        int lower = 0;
        int upper = 0;
        
        char c1 = word.charAt(0);
        int f = (c1 >= 65 && c1 <= 90) ? 1 : 0;
        
        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            
            if (c >= 65 && c <= 90)
                upper ++;
            else
                lower ++;
        }
        
        if (upper == 0 || lower == 0)
            return true;
        
        if (f == 1 && upper == 1)
            return true;
        
        return false;
    }
}