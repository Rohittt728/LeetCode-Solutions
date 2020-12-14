/*

Link : https://leetcode.com/problems/palindrome-partitioning/

Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

A palindrome string is a string that reads the same backward as forward.

Example 1:
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]

Example 2:
Input: s = "a"
Output: [["a"]]

Constraints:
1 <= s.length <= 16
s contains only lowercase English letters.

*/


// Solution 1 : Backtracking
class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> ans = new ArrayList<List<String>>();
        dfs(0, ans, new ArrayList<String>(), s);
        
        return ans;
    }
    
    public void dfs(int start, List<List<String>> ans, List<String> curr, String s) {
        
        if (start >= s.length())
            ans.add(new ArrayList<String>(curr));
        
        for (int i = start; i < s.length(); i++) {
            if(isPalin(s, start, i)) {
                curr.add(s.substring(start, i + 1));
                dfs(i + 1, ans, curr, s);
                curr.remove(curr.size() - 1);
            }
        }
    }
    
    public boolean isPalin(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}


// Solution 2 : DP
class Solution {
    public List<List<String>> partition(String s) {
        
        int len = s.length();
        boolean dp[][] = new boolean[len][len];
        List<List<String>> ans = new ArrayList<List<String>>();
        dfs(0, ans, new ArrayList<String>(), s, dp);
        
        return ans;
    }
    
    public void dfs(int start, List<List<String>> ans, List<String> curr, String s, boolean dp[][]) {
        
        if (start >= s.length())
            ans.add(new ArrayList<String>(curr));
        
        for (int i = start; i < s.length(); i++) {
            if(s.charAt(start) == s.charAt(i) && (i - start <= 2 || dp[start + 1][i - 1])) {
                dp[start][i] = true;
                curr.add(s.substring(start, i + 1));
                dfs(i + 1, ans, curr, s, dp);
                curr.remove(curr.size() - 1);
            }
        }
    }
}