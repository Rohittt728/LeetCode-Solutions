/*

Link : https://leetcode.com/problems/longest-common-subsequence/

Given two strings text1 and text2, return the length of their longest common subsequence.

A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.

If there is no common subsequence, return 0.

Example 1:
Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.

Example 2:
Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.

Example 3:
Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.

Constraints:
1 <= text1.length <= 1000
1 <= text2.length <= 1000
The input strings consist of lowercase English characters only.

*/



// Solution1 : DP
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int r = text1.length();
        int c = text2.length();
            
        int dp[][] = new int[r + 1][c + 1];
        for (int i = 0; i < r + 1; i ++)
            dp[i][0] = 0;
        for (int j = 0; j < c + 1; j ++)
            dp[0][j] = 0;
        
        for (int i = 1; i < r + 1; i++) {
            for (int j = 1; j < c + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[r][c];
    }
}



// Solution2 : Space Optimized DP
class Solution {

	// since we only need the current row & previous row
	// so numbers of rows in dp array reduces to 2
    public int longestCommonSubsequence(String text1, String text2) {
        
        int r = text1.length();
        int c = text2.length();
            
        int dp[][] = new int[2][c + 1];
        int row = 0;
        
        for (int i = 0; i < r + 1; i++) {
            row = i % 2;
            for (int j = 0; j < c + 1; j++) {
                if (i == 0 || j == 0)
                    dp[row][j] = 0;
                
                else if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[row][j] = dp[1 - row][j - 1] + 1;
                else
                    dp[row][j] = Math.max(dp[1 - row][j], dp[row][j - 1]);
            }
        }
        return dp[row][c];
    }
}