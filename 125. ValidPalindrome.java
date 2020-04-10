/*

Link : https://leetcode.com/problems/valid-palindrome/

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:
Input: "A man, a plan, a canal: Panama"
Output: true

Example 2:
Input: "race a car"
Output: false

*/


// Solution1 : Using extra string
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int l = s.length();
        
        String str = "";
        for (int i = 0; i < l; i++) {
            char c = s.charAt(i);
            if ((c >= 97 && c <= 122) || (c >= 48 && c <= 57))
                str = str + c;
        }
        
        l = str.length();
        for (int i = 0, j = l-1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j))
                return false;
        }
        return true;
    }
}


// Solution2 : without using extra string
class Solution {
    // same two pointer palindrome check approach while ignoring unwanted characters
    public boolean isPalindrome(String s) {
        if (s == null)
            return false;
        
        s = s.toLowerCase();
        int l = s.length();
        
        System.out.println (s);
        for (int i = 0, j = l-1; i < j; i++, j--) {
            while (i < j && !((s.charAt(i) >= 97 && s.charAt(i) <= 122) || (s.charAt(i) >= 48 && s.charAt(i) <= 57)))
                i++;
            while (i < j && !((s.charAt(j) >= 97 && s.charAt(j) <= 122) || (s.charAt(j) >= 48 && s.charAt(j) <= 57)))
                j--;
            if (s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }
}